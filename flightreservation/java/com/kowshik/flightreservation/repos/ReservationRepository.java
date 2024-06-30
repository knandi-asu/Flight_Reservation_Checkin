package com.kowshik.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kowshik.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
