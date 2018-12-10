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
}

