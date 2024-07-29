package com.example.reservas.dto;

public class DiscountRequest {
    private String userId;
    private String houseId;
    private String discountCode;

    public DiscountRequest(String userId, String houseId, String discountCode) {
        this.userId = userId;
        this.houseId = houseId;
        this.discountCode = discountCode;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

}
