package com.bsuir.course.repository;

import com.bsuir.course.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
    Account getAccountByMail(String mail);
}
