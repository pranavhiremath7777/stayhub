package com.pranav.stayhub_backend.tenant;

import com.pranav.stayhub_backend.bed.Bed;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal details
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    private String email;

    private LocalDate dateOfBirth;

    private String gender;

    private String emergencyContact;

    private String address;

    // Stay details
    @Column(nullable = false)
    private LocalDate moveInDate;

    private LocalDate moveOutDate;

    // Rent details
    @Column(nullable = false)
    private BigDecimal rentAmount;

    private BigDecimal securityDeposit;

    // Bed assignment
    @OneToOne
    @JoinColumn(name = "bed_id", unique = true)
    private Bed bed;

    public Tenant() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(LocalDate moveInDate) {
        this.moveInDate = moveInDate;
    }

    public LocalDate getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(LocalDate moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
    }

    public BigDecimal getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(BigDecimal securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
