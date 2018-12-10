package com.bsuir.course.service;

import com.bsuir.course.entity.Account;

import java.util.Optional;

public interface AccountService {
    Iterable<Account> findAllAccounts();
    Optional<Account> getById(Long id);
    Account saveAccount(Account account);
    void deleteAccountById(Long id);
}
