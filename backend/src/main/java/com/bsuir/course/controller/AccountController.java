package com.bsuir.course.controller;


import com.bsuir.course.entity.Account;
import com.bsuir.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/ba/accounts")
public class AccountController {

    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{mail}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountByMail(@PathVariable(name = "mail") String mail) {

        Account account = service.findAccountByMail(mail);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountByLoginAndPassword(@RequestParam(name = "login") String mail) {
        Account account = service.findAccountByMail(mail);
        return ResponseEntity.ok(account);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Account saveAccount(@RequestBody Account account) {
        return service.saveAccount(account);
    }
}
