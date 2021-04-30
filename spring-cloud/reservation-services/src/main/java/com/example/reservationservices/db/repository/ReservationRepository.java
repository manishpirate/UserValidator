package com.example.reservationservices.db.repository;

import com.example.reservationservices.db.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
