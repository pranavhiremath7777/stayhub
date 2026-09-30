package com.pranav.stayhub_backend.bed;

import com.pranav.stayhub_backend.room.Room;
import com.pranav.stayhub_backend.room.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedService {

    private final BedRepository bedRepository;
    private final RoomRepository roomRepository;

    public BedService(
            BedRepository bedRepository,
            RoomRepository roomRepository) {

        this.bedRepository = bedRepository;
        this.roomRepository = roomRepository;
    }

    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    public List<Bed> getBedsByRoom(Long roomId) {

        if (!roomRepository.existsById(roomId)) {
            throw new RuntimeException("Room not found");
        }

        return bedRepository.findByRoomId(roomId);
    }

    public Bed getBedById(Long id) {

        return bedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bed not found"));
    }

    public Bed createBed(Long roomId, Bed bed) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        bed.setRoom(room);

        if (bed.getStatus() == null) {
            bed.setStatus(BedStatus.AVAILABLE);
        }

        return bedRepository.save(bed);
    }

    public Bed updateBed(Long id, Bed updatedBed) {

        Bed bed = getBedById(id);

        bed.setBedNumber(updatedBed.getBedNumber());
        bed.setStatus(updatedBed.getStatus());

        return bedRepository.save(bed);
    }

    public void deleteBed(Long id) {

        Bed bed = getBedById(id);

        bedRepository.delete(bed);
    }
}
