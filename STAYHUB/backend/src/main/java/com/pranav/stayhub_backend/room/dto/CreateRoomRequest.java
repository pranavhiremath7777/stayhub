package com.pranav.stayhub_backend.room.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateRoomRequest {

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    @NotNull(message = "Floor is required")
    @Min(
            value = 0,
            message = "Floor cannot be negative"
    )
    private Integer floor;

    @NotNull(message = "Total beds is required")
    @Min(
            value = 1,
            message = "Room must have at least 1 bed"
    )
    private Integer totalBeds;

    public CreateRoomRequest() {
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(Integer totalBeds) {
        this.totalBeds = totalBeds;
    }
}
