package com.bsuir.course.service.serviceImpl;

import com.bsuir.course.entity.Booking;
import com.bsuir.course.entity.Room;
import com.bsuir.course.repository.BookingRepository;
import com.bsuir.course.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository repository;

    @Autowired
    public BookingServiceImpl(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteBookingById(Long id) {
repository.deleteById(id);
    }

    @Override
    public Optional<Booking> findBookingById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Booking> findAllBookings() {
        return repository.findAll();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return repository.save(booking);
    }


}
