package com.example.reservas.service.impl;

import com.example.reservas.exception.InvalidRequestException;
import com.example.reservas.dto.ReservationRequest;
import com.example.reservas.dto.DiscountRequest;
import com.example.reservas.model.Reservation;
import com.example.reservas.repository.ReservationRepository;
import com.example.reservas.service.ReservationService;
import com.example.reservas.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private DiscountService discountService;

    @Override
    public void validateRequest(ReservationRequest request) throws InvalidRequestException {
        if (request.getHouseId() == null) {
            throw new InvalidRequestException("Required property 'houseId'");
        }
    }

    @Override
    public boolean checkDiscount(ReservationRequest request) {
        DiscountRequest discountRequest = new DiscountRequest(request.getUserId(), request.getHouseId(), request.getDiscountCode());
        try {
            return discountService.validateDiscount(discountRequest).isStatus();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void saveReservation(ReservationRequest request) {
        Reservation reservation = new Reservation(request);
        reservationRepository.save(reservation);
    }
}
