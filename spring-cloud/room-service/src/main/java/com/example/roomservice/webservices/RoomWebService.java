package com.example.roomservice.webservices;

import com.example.roomservice.db.entity.Room;
import com.example.roomservice.db.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomWebService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomWebService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public Iterable<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id){
        return roomRepository.findById(id).get();
    }

}
