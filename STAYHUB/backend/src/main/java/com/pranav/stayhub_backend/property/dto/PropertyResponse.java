package com.pranav.stayhub_backend.property.dto;

import com.pranav.stayhub_backend.property.Property;

public class PropertyResponse {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private String phone;

    public PropertyResponse(Property property) {
        this.id = property.getId();
        this.name = property.getName();
        this.address = property.getAddress();
        this.city = property.getCity();
        this.state = property.getState();
        this.pincode = property.getPincode();
        this.phone = property.getPhone();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    public String getPhone() {
        return phone;
    }
}
