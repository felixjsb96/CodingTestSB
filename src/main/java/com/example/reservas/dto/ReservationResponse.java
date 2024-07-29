package com.example.reservas.dto;

public class ReservationResponse {
    private String message;
    private ReservationRequest reservationRequest;

    public ReservationResponse(String message, ReservationRequest reservationRequest) {
        this.message = message;
        this.reservationRequest = reservationRequest;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ReservationRequest getReservationRequest() {
		return reservationRequest;
	}

	public void setReservationRequest(ReservationRequest reservationRequest) {
		this.reservationRequest = reservationRequest;
	}


}
