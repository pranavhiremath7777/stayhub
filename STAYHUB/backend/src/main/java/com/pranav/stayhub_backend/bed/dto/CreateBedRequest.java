package com.pranav.stayhub_backend.bed.dto;

import com.pranav.stayhub_backend.bed.BedStatus;

public class CreateBedRequest {

    private String bedNumber;
    private BedStatus status;

    public CreateBedRequest() {
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public BedStatus getStatus() {
        return status;
    }

    public void setStatus(BedStatus status) {
        this.status = status;
    }
}
