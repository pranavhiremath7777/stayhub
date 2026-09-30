package com.pranav.stayhub_backend.room.dto;

import com.pranav.stayhub_backend.room.Room;

public class RoomResponse {

    private Long id;
    private String roomNumber;
    private Integer floor;
    private Integer totalBeds;
    private Long propertyId;
    private String propertyName;

    public RoomResponse(Room room) {
        this.id = room.getId();
        this.roomNumber = room.getRoomNumber();
        this.floor = room.getFloor();
        this.totalBeds = room.getTotalBeds();

        if (room.getProperty() != null) {
            this.propertyId = room.getProperty().getId();
            this.propertyName = room.getProperty().getName();
        }
    }

    public Long getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public Integer getTotalBeds() {
        return totalBeds;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
