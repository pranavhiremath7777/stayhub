package com.pranav.stayhub_backend.room;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pranav.stayhub_backend.common.exception.ResourceNotFoundException;
import com.pranav.stayhub_backend.property.Property;
import com.pranav.stayhub_backend.property.PropertyRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final PropertyRepository propertyRepository;

    public RoomService(
            RoomRepository roomRepository,
            PropertyRepository propertyRepository) {

        this.roomRepository = roomRepository;
        this.propertyRepository = propertyRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getRoomsByProperty(Long propertyId) {

        if (!propertyRepository.existsById(propertyId)) {
            throw new ResourceNotFoundException("Property not found");
        }

        return roomRepository.findByPropertyId(propertyId);
    }

    public Room getRoomById(Long id) {

        return roomRepository.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Room not found"));
    }

    public Room createRoom(Long propertyId, Room room) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Property not found"));

        room.setProperty(property);

        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room updatedRoom) {

        Room room = getRoomById(id);

        room.setRoomNumber(updatedRoom.getRoomNumber());
        room.setFloor(updatedRoom.getFloor());
        room.setTotalBeds(updatedRoom.getTotalBeds());

        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {

        Room room = getRoomById(id);

        roomRepository.delete(room);
    }
}
