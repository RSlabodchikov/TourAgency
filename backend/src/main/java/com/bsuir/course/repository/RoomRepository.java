package com.bsuir.course.repository;

import com.bsuir.course.entity.Room;
import com.bsuir.course.entity.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    @Query(value = "select *" +
            " from rooms r" +
            " where r.id not in (select b3.id" +
            " from (select * from bookings b1 where (b1.settlement_date <= :inputDate2 AND b1.eviction_date >= :inputDate1)) b3" +
            " inner join rooms r2 on b3.room_id = r2.id) and r.number_of_clients = :inputNumber", nativeQuery = true)
    Iterable<Room> getRoomByDates(@Param("inputDate2") Date settlementDate, @Param("inputDate1") Date evictionDate, @Param("inputNumber") int number);
}
