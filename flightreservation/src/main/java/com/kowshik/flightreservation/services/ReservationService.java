package com.kowshik.flightreservation.services;

import com.kowshik.flightreservation.dtos.ReservationRequest;
import com.kowshik.flightreservation.entities.Reservation;

public interface ReservationService {
	
	Reservation bookFlight(ReservationRequest request);
	
}
