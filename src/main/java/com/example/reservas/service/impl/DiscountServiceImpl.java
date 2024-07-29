package com.example.reservas.service.impl;

import com.example.reservas.dto.DiscountRequest;
import com.example.reservas.dto.DiscountResponse;
import com.example.reservas.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final RestTemplate restTemplate;

    @Autowired
    public DiscountServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Retryable(
        value = { RestClientException.class },
        maxAttempts = 3,
        backoff = @Backoff(delay = 2000)
    )
    public DiscountResponse validateDiscount(DiscountRequest request) {
        String apiUrl = "https://sbv2bumkomidlxwffpgbh4k6jm0ydskh.lambda-url.us-east-1.on.aws";
        try {
            return restTemplate.postForObject(apiUrl, request, DiscountResponse.class);
        } catch (RestClientException e) {
            throw e;
        }
    }

    @Recover
    public DiscountResponse recover(RestClientException e, DiscountRequest request) {
        return null;
    }
}
