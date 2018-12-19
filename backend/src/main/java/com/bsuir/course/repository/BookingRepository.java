package com.bsuir.course.repository;

import com.bsuir.course.entity.Booking;
import com.bsuir.course.entity.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    @Query(value = "select * from bookings b where b.client_id in (select c.id from clients c where c.account_id in (select a.id from accounts a where a.mail = :inputMail))",nativeQuery = true )
    Iterable<Booking> findAllByClientMail(@Param("inputMail")String mail);
}

