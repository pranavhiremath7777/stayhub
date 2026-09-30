package com.pranav.stayhub_backend.property;

import com.pranav.stayhub_backend.property.dto.CreatePropertyRequest;
import com.pranav.stayhub_backend.property.dto.PropertyResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "http://localhost:5173")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<PropertyResponse> getAllProperties() {
        return propertyService.getAllProperties()
                .stream()
                .map(PropertyResponse::new)
                .toList();
    }

    @GetMapping("/{id}")
    public PropertyResponse getProperty(@PathVariable Long id) {
        return new PropertyResponse(
                propertyService.getPropertyById(id)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyResponse createProperty(
            @Valid @RequestBody CreatePropertyRequest request) {

        Property property = new Property();

        property.setName(request.getName());
        property.setAddress(request.getAddress());
        property.setCity(request.getCity());
        property.setState(request.getState());
        property.setPincode(request.getPincode());
        property.setPhone(request.getPhone());

        return new PropertyResponse(
                propertyService.createProperty(property)
        );
    }

    @PutMapping("/{id}")
    public PropertyResponse updateProperty(
            @PathVariable Long id,
            @Valid @RequestBody CreatePropertyRequest request) {

        Property property = new Property();

        property.setName(request.getName());
        property.setAddress(request.getAddress());
        property.setCity(request.getCity());
        property.setState(request.getState());
        property.setPincode(request.getPincode());
        property.setPhone(request.getPhone());

        return new PropertyResponse(
                propertyService.updateProperty(id, property)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }
}
