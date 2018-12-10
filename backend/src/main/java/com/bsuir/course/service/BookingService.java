package com.bsuir.course.service;

import com.bsuir.course.entity.Booking;
import com.bsuir.course.entity.Room;

import java.sql.Date;
import java.util.Optional;

public interface BookingService {
    void deleteBookingById(Long id);

    Optional<Booking> findBookingById(Long id);

    Iterable<Booking> findAllBookings();

    Booking saveBooking(Booking booking);

}
