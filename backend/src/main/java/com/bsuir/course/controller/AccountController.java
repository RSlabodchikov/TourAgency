package com.bsuir.course.controller;

import com.bsuir.course.entity.Account;
import com.bsuir.course.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.OpenDataException;
import java.util.Optional;

@RestController
@RequestMapping("/ba/accounts")
public class AccountController {

    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public Iterable<Account> getAllAccounts(){
        return service.findAllAccounts();
    }

    @RequestMapping(value="/{id}",method =RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable(name="id")Long id){
        Optional<Account> account=service.getById(id);
        if (account.isPresent()){
            return ResponseEntity.ok(account.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccountById(@PathVariable(name="id")Long id){
        service.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Account  saveAccount(@RequestBody Account account){
        return service.saveAccount(account);
    }
}
