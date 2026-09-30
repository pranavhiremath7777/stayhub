package com.pranav.stayhub_backend.bed;

import com.pranav.stayhub_backend.bed.dto.BedResponse;
import com.pranav.stayhub_backend.bed.dto.CreateBedRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class BedController {

    private final BedService bedService;

    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @GetMapping("/beds")
    public List<BedResponse> getAllBeds() {
        return bedService.getAllBeds()
                .stream()
                .map(BedResponse::new)
                .toList();
    }

    @GetMapping("/beds/{id}")
    public BedResponse getBed(@PathVariable Long id) {
        return new BedResponse(
                bedService.getBedById(id)
        );
    }

    @GetMapping("/rooms/{roomId}/beds")
    public List<BedResponse> getBedsByRoom(
            @PathVariable Long roomId) {

        return bedService.getBedsByRoom(roomId)
                .stream()
                .map(BedResponse::new)
                .toList();
    }

    @PostMapping("/rooms/{roomId}/beds")
    @ResponseStatus(HttpStatus.CREATED)
    public BedResponse createBed(
            @PathVariable Long roomId,
            @RequestBody CreateBedRequest request) {

        Bed bed = new Bed();

        bed.setBedNumber(request.getBedNumber());
        bed.setStatus(request.getStatus());

        return new BedResponse(
                bedService.createBed(roomId, bed)
        );
    }

    @PutMapping("/beds/{id}")
    public BedResponse updateBed(
            @PathVariable Long id,
            @RequestBody CreateBedRequest request) {

        Bed bed = new Bed();

        bed.setBedNumber(request.getBedNumber());
        bed.setStatus(request.getStatus());

        return new BedResponse(
                bedService.updateBed(id, bed)
        );
    }

    @DeleteMapping("/beds/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBed(@PathVariable Long id) {
        bedService.deleteBed(id);
    }
}
