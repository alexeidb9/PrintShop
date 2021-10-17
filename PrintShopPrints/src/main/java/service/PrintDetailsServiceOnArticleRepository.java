package main.java.service;


import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import main.java.repository.PrintRepository;
import main.java.service.models.AddPrint;
import main.java.service.models.GetPrint;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.jacket.data.models.Article;
import com.pluralsight.jacket.data.models.User;
import com.pluralsight.jacket.security.repository.UsersRepository;

@Service
@Transactional(readOnly = true)
public class PrintDetailsServiceOnArticleRepository implements PrintArticleService {

	PrintRepository entryRepository;
	UsersRepository userRepository;
	Log log;

	@Inject
	public PrintDetailsServiceOnArticleRepository(PrintRepository entryRepository, UsersRepository userRepository, Log log) {
		this.entryRepository = entryRepository;
		this.userRepository = userRepository;
		this.log = log;
	}

	@Override
	public List<GetPrint> getAllArticles(long id) {
		Iterable<Print> prints = entryRepository.findByUserId(id);
		List<GetPrint> serviceEntries = new LinkedList<GetPrint>();
		if (prints != null) {
			prints.forEach(e -> serviceEntries.add(
					new GetPrint(e.getUser().getId(), e.getUrl(), e.getTitle(), e.getId()/*, getImageFromEntryByteArray(e)*/)));
		} else {
			log.debug("*********** repository return null");
		}
		return serviceEntries;
	}


	@Override
	@Transactional(readOnly = false)
	public void updateArticle(AddJacketArticle entry) {

	}

	@Override
	@Transactional(readOnly = false)
	public long addPrint(AddPrint entry) {

		if (entry == null)
			throw new PrintServiceException("Unable to add an entry for " + entry);
		if (entry.getTitle() == null)
			throw new PrintServiceException("Unable to add an entry for " + entry);
		if (entry.getUrl() == null)
			throw new PrintServiceException("Unable to add an entry for " + entry);
		if (entry.getImage() == null)
			throw new PrintServiceException("Unable to add an entry for " + entry);

		User user = userRepository.findOne(entry.getUserId());
		Article entry = new Article();

		entry.setUser(user);		
		entry.setTitle(entry.getTitle());
		entry.setUrl(entry.getUrl());
		entry.setImage(getByteArrayFromImage(entry.getImage(), log));

		entryRepository.save(entry);
		return entry.getId();
	}

	@Override
	public GetPrint getPrint(long id) {
		Print entry = entryRepository.findOne(id);

		if (entry == null)
			throw new PrintServiceException("Unable to find entry in repository for id " + id);
		Long userId = entry.getUser().getId(); 
		String url = entry.getUrl(); 
		String title = entry.getTitle();
		Long entryid = entry.getId();
		
		GetPrint jacketEntry = new GetPrint(userId, url, title, entryid);

		return jacketEntry;
	}
	
	@Override
	public Image getArticleImage(Long entryId) {
		Print entry = entryRepository.findOne(entryId);

		if (entry == null)
			throw new PrintServiceException("Unable to find entry in repository for id " + entryId);

		byte[] bytes = entry.getImage();
		return getImageFromByteArray(bytes, log);
	}


}
