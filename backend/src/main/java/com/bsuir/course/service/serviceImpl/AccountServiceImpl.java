package com.bsuir.course.service.serviceImpl;


import com.bsuir.course.entity.Account;
import com.bsuir.course.repository.AccountRepository;
import com.bsuir.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("accountService")
public class AccountServiceImpl implements AccountService, UserDetailsService {

    private AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Account findAccountByMail(String mail) {
        return repository.getAccountByMail(mail);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.getAccountByMail(username);
        if (account != null) {
            return new User(account.getMail(), account.getPassword(), getAuthority(account));
        } else {
            throw new UsernameNotFoundException("Invalid login or password");
        }
    }

    private Set<GrantedAuthority> getAuthority(Account account) {
        Set<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}
