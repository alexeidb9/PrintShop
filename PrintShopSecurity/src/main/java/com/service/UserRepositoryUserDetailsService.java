

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserRepositoryUserDetailsService implements PrintShopUserService {
	private final UsersRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserRepositoryUserDetailsService(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public AuthenticatedUser registerNewUserAccount(JacketUser serviceUser) throws EmailExistsException {

		// todo: return false
		if (emailExist(serviceUser.getEmail())) {
			throw new EmailExistsException("There is an account with that email adress:" + serviceUser.getEmail());
		}

		User user = new User();
		user.setFirstName(serviceUser.getFirstName());
		user.setLastName(serviceUser.getLastName());

		user.setPassword(passwordEncoder.encode(serviceUser.getPassword()));

		user.setEmail(serviceUser.getEmail());

		if (userRepository.save(user) != null) {
			AuthenticatedUser authenticatedUser = new AuthenticatedUser(user);
			Authentication auth = new UsernamePasswordAuthenticationToken(authenticatedUser, null,
					new ArrayList<GrantedAuthority>());
			
			// todo: wrap this is a bean?
			SecurityContextHolder.getContext().setAuthentication(auth);

			return authenticatedUser;
		}

		return null;
	}

	private boolean emailExist(String email) {
		return userRepository.findByEmail(email) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user " + username);
		}
		return new AuthenticatedUser(user);
	}
}
