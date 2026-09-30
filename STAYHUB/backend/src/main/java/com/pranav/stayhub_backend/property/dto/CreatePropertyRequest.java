package com.pranav.stayhub_backend.property.dto;

import jakarta.validation.constraints.NotBlank;

public class CreatePropertyRequest {

    @NotBlank(message = "Property name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    private String city;
    private String state;
    private String pincode;
    private String phone;

    public CreatePropertyRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
