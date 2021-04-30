package com.example.roomreservationservice.webservice;

import com.example.roomreservationservice.Room;
import com.example.roomreservationservice.client.RoomClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationWebService {

    private final RoomClient roomClient;

    public RoomReservationWebService(RoomClient roomClient) {
        this.roomClient = roomClient;
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomClient.getAllRooms();
    }
}
