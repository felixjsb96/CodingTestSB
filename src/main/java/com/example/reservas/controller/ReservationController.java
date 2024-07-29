package com.example.reservas.controller;

import com.example.reservas.exception.InvalidRequestException;
import com.example.reservas.dto.ReservationRequest;
import com.example.reservas.dto.ErrorResponse;
import com.example.reservas.dto.SuccessResponse;
import com.example.reservas.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestBody ReservationRequest reservationRequest) {
        try {
            reservationService.validateRequest(reservationRequest);

            if (reservationRequest.getDiscountCode() != null) {
                boolean isDiscountValid = reservationService.checkDiscount(reservationRequest);
                if (!isDiscountValid) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(new ErrorResponse(409, "Conflict", "Descuento no válido"));
                }
            }

            reservationService.saveReservation(reservationRequest);
            return ResponseEntity.ok(new SuccessResponse(200, "Libro aceptado"));

        } catch (InvalidRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(400, "Bad Request", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(500, "Internal Server Error", "Ocurrió un error inesperado"));
        }
    }
}
