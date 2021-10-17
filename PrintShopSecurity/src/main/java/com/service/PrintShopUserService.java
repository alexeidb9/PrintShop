package com.pluralsight.jacket.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface PrintShopUserService extends UserDetailsService {
    public AuthenticatedUser registerNewUserAccount(PrintShopUser accountDto) throws EmailExistsException;
}
