package com.example.reservas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

import org.antlr.v4.runtime.misc.NotNull;

import com.example.reservas.dto.ReservationRequest;

import java.sql.Date;

@Entity
@Table(name = "book")
public class Reservation {

    @Id
    private UUID id;

    private String userId;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private Integer age;

    @NotNull
    private String phone_number;

    @NotNull
    private Date start_dte;

    @NotNull
    private Date end_date;

    @NotNull
    private String house_id;

    private String discount_code;

	public Reservation(ReservationRequest request) {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getStart_dte() {
		return start_dte;
	}

	public void setStart_dte(Date start_dte) {
		this.start_dte = start_dte;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getHouse_id() {
		return house_id;
	}

	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}

	public String getDiscount_code() {
		return discount_code;
	}

	public void setDiscount_code(String discount_code) {
		this.discount_code = discount_code;
	}

}

