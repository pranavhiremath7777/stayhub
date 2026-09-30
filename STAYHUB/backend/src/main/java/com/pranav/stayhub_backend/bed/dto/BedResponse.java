package com.pranav.stayhub_backend.bed.dto;

import com.pranav.stayhub_backend.bed.Bed;

public class BedResponse {

    private Long id;
    private String bedNumber;
    private String status;
    private Long roomId;
    private String roomNumber;

    public BedResponse(Bed bed) {
        this.id = bed.getId();
        this.bedNumber = bed.getBedNumber();
        this.status = bed.getStatus().name();

        if (bed.getRoom() != null) {
            this.roomId = bed.getRoom().getId();
            this.roomNumber = bed.getRoom().getRoomNumber();
        }
    }

    public Long getId() {
        return id;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public String getStatus() {
        return status;
    }

    public Long getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}
