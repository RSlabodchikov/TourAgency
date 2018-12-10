package com.bsuir.course.service;

import com.bsuir.course.entity.Room;

import java.sql.Date;
import java.util.Optional;

public interface RoomService {
    Iterable<Room> findAllRooms();

    Optional<Room> findRoomById(Long id);

    Room saveRoom(Room room);

    void deleteRoomById(Long id);

    Iterable<Room> getRoomBySettlementDate(Date settlementDate, Date evictionDate, int number);
}
