package com.example.reservationservices.webservices;

import com.example.reservationservices.db.entity.Reservation;
import com.example.reservationservices.db.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationWebServices {


    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationWebServices(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public Iterable<Reservation> getReservation() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id).get();
    }


}

