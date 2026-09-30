package com.pranav.stayhub_backend.tenant;

import com.pranav.stayhub_backend.tenant.dto.TenantRequest;
import com.pranav.stayhub_backend.tenant.dto.TenantResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin(origins = "http://localhost:5173")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<TenantResponse> getAllTenants() {
        return tenantService.getAllTenants()
                .stream()
                .map(TenantResponse::new)
                .toList();
    }

    @GetMapping("/{id}")
    public TenantResponse getTenant(@PathVariable Long id) {
        return new TenantResponse(
                tenantService.getTenantById(id)
        );
    }

    @PostMapping("/bed/{bedId}")
    @ResponseStatus(HttpStatus.CREATED)
    public TenantResponse createTenant(
            @PathVariable Long bedId,
            @RequestBody TenantRequest request) {

        Tenant tenant = new Tenant();

        tenant.setName(request.getName());
        tenant.setPhone(request.getPhone());
        tenant.setEmail(request.getEmail());
        tenant.setDateOfBirth(request.getDateOfBirth());
        tenant.setGender(request.getGender());
        tenant.setEmergencyContact(request.getEmergencyContact());
        tenant.setAddress(request.getAddress());
        tenant.setMoveInDate(request.getMoveInDate());
        tenant.setMoveOutDate(request.getMoveOutDate());
        tenant.setRentAmount(request.getRentAmount());
        tenant.setSecurityDeposit(request.getSecurityDeposit());

        return new TenantResponse(
                tenantService.createTenant(bedId, tenant)
        );
    }

    @PutMapping("/{id}")
    public TenantResponse updateTenant(
            @PathVariable Long id,
            @RequestBody TenantRequest request) {

        Tenant tenant = new Tenant();

        tenant.setName(request.getName());
        tenant.setPhone(request.getPhone());
        tenant.setEmail(request.getEmail());
        tenant.setDateOfBirth(request.getDateOfBirth());
        tenant.setGender(request.getGender());
        tenant.setEmergencyContact(request.getEmergencyContact());
        tenant.setAddress(request.getAddress());
        tenant.setMoveInDate(request.getMoveInDate());
        tenant.setMoveOutDate(request.getMoveOutDate());
        tenant.setRentAmount(request.getRentAmount());
        tenant.setSecurityDeposit(request.getSecurityDeposit());

        return new TenantResponse(
                tenantService.updateTenant(id, tenant)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
    }
}
