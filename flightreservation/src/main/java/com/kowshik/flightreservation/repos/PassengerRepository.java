package com.kowshik.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kowshik.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
