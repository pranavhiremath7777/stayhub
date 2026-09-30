package com.pranav.stayhub_backend.tenant.dto;

import com.pranav.stayhub_backend.tenant.Tenant;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TenantResponse {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private String emergencyContact;
    private String address;
    private LocalDate moveInDate;
    private LocalDate moveOutDate;
    private BigDecimal rentAmount;
    private BigDecimal securityDeposit;

    private Long bedId;
    private String bedNumber;
    private String bedStatus;

    public TenantResponse(Tenant tenant) {
        this.id = tenant.getId();
        this.name = tenant.getName();
        this.phone = tenant.getPhone();
        this.email = tenant.getEmail();
        this.dateOfBirth = tenant.getDateOfBirth();
        this.gender = tenant.getGender();
        this.emergencyContact = tenant.getEmergencyContact();
        this.address = tenant.getAddress();
        this.moveInDate = tenant.getMoveInDate();
        this.moveOutDate = tenant.getMoveOutDate();
        this.rentAmount = tenant.getRentAmount();
        this.securityDeposit = tenant.getSecurityDeposit();

        if (tenant.getBed() != null) {
            this.bedId = tenant.getBed().getId();
            this.bedNumber = tenant.getBed().getBedNumber();
            this.bedStatus = tenant.getBed().getStatus().name();
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public LocalDate getMoveOutDate() {
        return moveOutDate;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public BigDecimal getSecurityDeposit() {
        return securityDeposit;
    }

    public Long getBedId() {
        return bedId;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public String getBedStatus() {
        return bedStatus;
    }
}
