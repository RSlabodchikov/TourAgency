package com.bsuir.course.controller;


import com.bsuir.course.entity.Room;
import com.bsuir.course.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/rooms/")
public class RoomController {
    private RoomService service;

    @Autowired
    public RoomController(RoomService service) {
        this.service = service;
    }

    @RequestMapping(value="/date", method= RequestMethod.GET)
    Iterable<Room> getRoomsBySettlementDate(@RequestParam(name="date")Date date){
        return service.getRoomBySettlementDate(date);
    }
}
