package com.bsuir.course.service;

import com.bsuir.course.entity.Account;

import java.util.Optional;

public interface AccountService {
    Account saveAccount(Account account);
    Account findAccountByMail(String mail);
}
