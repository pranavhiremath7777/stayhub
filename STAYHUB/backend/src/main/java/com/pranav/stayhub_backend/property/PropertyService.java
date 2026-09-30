package com.pranav.stayhub_backend.property;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pranav.stayhub_backend.common.exception.ResourceNotFoundException;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Long id) {

        return propertyRepository.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Property not found"));
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property updateProperty(
            Long id,
            Property updatedProperty) {

        Property property = getPropertyById(id);

        property.setName(updatedProperty.getName());
        property.setAddress(updatedProperty.getAddress());
        property.setCity(updatedProperty.getCity());
        property.setState(updatedProperty.getState());
        property.setPincode(updatedProperty.getPincode());
        property.setPhone(updatedProperty.getPhone());

        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {

        Property property = getPropertyById(id);

        propertyRepository.delete(property);
    }
}
