package com.bsuir.course.service.serviceImpl;


import com.bsuir.course.entity.Account;
import com.bsuir.course.repository.AccountRepository;
import com.bsuir.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {


    private AccountRepository repository;


    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public Iterable<Account> findAllAccounts() {
        return repository.findAll();
    }

    @Override
    public Optional<Account> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public void deleteAccountById(Long id) {
        repository.deleteById(id);
    }
}
