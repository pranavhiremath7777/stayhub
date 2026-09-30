package com.pranav.stayhub_backend.room;

import com.pranav.stayhub_backend.room.dto.CreateRoomRequest;
import com.pranav.stayhub_backend.room.dto.RoomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<RoomResponse> getAllRooms() {
        return roomService.getAllRooms()
                .stream()
                .map(RoomResponse::new)
                .toList();
    }

    @GetMapping("/rooms/{id}")
    public RoomResponse getRoom(@PathVariable Long id) {
        return new RoomResponse(
                roomService.getRoomById(id)
        );
    }

    @GetMapping("/properties/{propertyId}/rooms")
    public List<RoomResponse> getRoomsByProperty(
            @PathVariable Long propertyId) {

        return roomService.getRoomsByProperty(propertyId)
                .stream()
                .map(RoomResponse::new)
                .toList();
    }

    @PostMapping("/properties/{propertyId}/rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomResponse createRoom(
            @PathVariable Long propertyId,
            @RequestBody CreateRoomRequest request) {

        Room room = new Room();

        room.setRoomNumber(request.getRoomNumber());
        room.setFloor(request.getFloor());
        room.setTotalBeds(request.getTotalBeds());

        return new RoomResponse(
                roomService.createRoom(propertyId, room)
        );
    }

    @PutMapping("/rooms/{id}")
    public RoomResponse updateRoom(
            @PathVariable Long id,
            @RequestBody CreateRoomRequest request) {

        Room room = new Room();

        room.setRoomNumber(request.getRoomNumber());
        room.setFloor(request.getFloor());
        room.setTotalBeds(request.getTotalBeds());

        return new RoomResponse(
                roomService.updateRoom(id, room)
        );
    }

    @DeleteMapping("/rooms/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}
