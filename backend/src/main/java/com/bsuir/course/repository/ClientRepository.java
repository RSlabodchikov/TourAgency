package com.bsuir.course.repository;

import com.bsuir.course.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    @Query(value="select * from clients c where c.account_id in (select a.id from accounts a where a.mail = :inputMail)",nativeQuery = true)
    Optional<Client> findClientByMail(@Param("inputMail")String mail);
}
