package com.example.reservas.service;

import com.example.reservas.dto.DiscountRequest;
import com.example.reservas.dto.DiscountResponse;

public interface DiscountService {
    DiscountResponse validateDiscount(DiscountRequest request);
}
