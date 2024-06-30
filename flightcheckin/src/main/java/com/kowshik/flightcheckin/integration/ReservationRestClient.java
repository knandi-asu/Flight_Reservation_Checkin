package com.kowshik.flightcheckin.integration;

import com.kowshik.flightcheckin.integration.dto.Reservation;
import com.kowshik.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	public Reservation updateReservation(ReservationUpdateRequest request);
}
