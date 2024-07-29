package com.example.reservas.dto;

public class DiscountResponse {
    private boolean status;

    public DiscountResponse() {
    }

    public DiscountResponse(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
