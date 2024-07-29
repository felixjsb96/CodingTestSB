package com.example.reservas.service;

import com.example.reservas.exception.InvalidRequestException;
import com.example.reservas.dto.ReservationRequest;

public interface ReservationService {
    void validateRequest(ReservationRequest request) throws InvalidRequestException;
    boolean checkDiscount(ReservationRequest request);
    void saveReservation(ReservationRequest request);
}
