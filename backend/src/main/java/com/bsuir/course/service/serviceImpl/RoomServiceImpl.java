package com.bsuir.course.service.serviceImpl;

import com.bsuir.course.entity.Room;
import com.bsuir.course.repository.RoomRepository;
import com.bsuir.course.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository repository;

    @Autowired
    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Room> findAllRooms() {
        return repository.findAll();
    }

    @Override
    public Optional<Room> findRoomById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Room saveRoom(Room room) {
        return repository.save(room);
    }

    @Override
    public void deleteRoomById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Room> getRoomBySettlementDate(Date settlementDate, Date evictionDate, int number) {
        return repository.getRoomByDates(settlementDate, evictionDate, number);
    }
}
