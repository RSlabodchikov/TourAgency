package com.bsuir.course.controller;


import com.bsuir.course.entity.Booking;
import com.bsuir.course.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/ba/bookings")
public class BookingController {

    private BookingService service;

    @Autowired
    public BookingController(BookingService service) {
        this.service = service;
    }


    @RequestMapping(method=RequestMethod.GET)
    public Iterable<Booking> getAllBookings(){
        return service.findAllBookings();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
        Optional<Booking> booking=service.findBookingById(id);
        if (booking.isPresent()){
            return ResponseEntity.ok(booking.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method=RequestMethod.POST)
    public Booking saveBooking(@RequestBody Booking booking){
        return service.saveBooking(booking);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id){
        service.deleteBookingById(id);
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value="/clients", method=RequestMethod.GET)
    public Iterable<Booking> getAllByMail(@RequestParam(name="mail")String mail){
        return service.findBookingByUserMail(mail);
    }
}
