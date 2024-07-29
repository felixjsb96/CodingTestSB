package com.example.reservas.service;

import com.example.reservas.dto.DiscountResponse;
import com.example.reservas.dto.ReservationRequest;
import com.example.reservas.dto.ReservationResponse;
import com.example.reservas.exception.InvalidRequestException;
import com.example.reservas.model.Reservation;
import com.example.reservas.repository.ReservationRepository;
import com.example.reservas.service.impl.ReservationServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    public ReservationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateRequest() {
        ReservationRequest request = new ReservationRequest();
        request.setHouseId("123");
        assertDoesNotThrow(() -> reservationService.validateRequest(request));
    }

    @Test
    public void testCheckDiscount() {
        ReservationRequest request = new ReservationRequest();
        request.setUserId("14564088-4");
        request.setHouseId("213132");
        request.setDiscountCode("D0542A23");

        when(discountService.validateDiscount(any())).thenReturn(new DiscountResponse(true));

        boolean isDiscountValid = reservationService.checkDiscount(request);

        assertTrue(isDiscountValid);
    }

    @Test
    public void testSaveReservation() {
        ReservationRequest request = new ReservationRequest();
        request.setHouseId("213132");

        reservationService.saveReservation(request);

        verify(reservationRepository, times(1)).save(any(Reservation.class));
    }
}
