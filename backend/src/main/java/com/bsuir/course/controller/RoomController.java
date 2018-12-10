package com.bsuir.course.controller;


import com.bsuir.course.entity.Room;
import com.bsuir.course.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private RoomService service;

    @Autowired
    public RoomController(RoomService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Room> getAllRooms() {
        return service.findAllRooms();
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public Iterable<Room> getRoomsBySettlementDate(@RequestParam(name = "settlementDate") Date settlementDate, @RequestParam(name = "evictionDate") Date evictionDate, @RequestParam(name = "number") int number) {
        return service.getRoomBySettlementDate(settlementDate, evictionDate, number);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Room> getRoomById(@PathVariable(name="id")Long id){
        Optional<Room> room=service.findRoomById(id);
        if (room.isPresent()){
            return ResponseEntity.ok(room.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Room saveRoom(@RequestBody Room room){
        return service.saveRoom(room);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteRoomById(@PathVariable(name="id")Long id){
        service.deleteRoomById(id);
    }
}
