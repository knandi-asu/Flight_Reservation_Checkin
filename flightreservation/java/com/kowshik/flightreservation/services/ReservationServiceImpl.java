package com.kowshik.flightreservation.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kowshik.flightreservation.dtos.ReservationRequest;
import com.kowshik.flightreservation.entities.Flight;
import com.kowshik.flightreservation.entities.Passenger;
import com.kowshik.flightreservation.entities.Reservation;
import com.kowshik.flightreservation.repos.FlightRepository;
import com.kowshik.flightreservation.repos.PassengerRepository;
import com.kowshik.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {	
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//Creditcard details & make a payment
		
		Flight flight = flightRepository.findById(request.getFlightId()).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
