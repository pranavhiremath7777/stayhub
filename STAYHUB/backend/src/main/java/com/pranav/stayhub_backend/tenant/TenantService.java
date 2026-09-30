package com.pranav.stayhub_backend.tenant;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pranav.stayhub_backend.bed.Bed;
import com.pranav.stayhub_backend.bed.BedRepository;
import com.pranav.stayhub_backend.bed.BedStatus;
import com.pranav.stayhub_backend.common.exception.ResourceNotFoundException;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final BedRepository bedRepository;

    public TenantService(
            TenantRepository tenantRepository,
            BedRepository bedRepository) {

        this.tenantRepository = tenantRepository;
        this.bedRepository = bedRepository;
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Tenant getTenantById(Long id) {

        return tenantRepository.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Tenant not found"));
    }

    public Tenant createTenant(Long bedId, Tenant tenant) {

        Bed bed = bedRepository.findById(bedId)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Bed not found"));

        if (bed.getStatus() != BedStatus.AVAILABLE) {
            throw new RuntimeException("Bed is not available");
        }

        tenant.setBed(bed);

        Tenant savedTenant = tenantRepository.save(tenant);

        bed.setStatus(BedStatus.OCCUPIED);
        bedRepository.save(bed);

        return savedTenant;
    }

    public Tenant updateTenant(Long id, Tenant updatedTenant) {

        Tenant tenant = getTenantById(id);

        tenant.setName(updatedTenant.getName());
        tenant.setPhone(updatedTenant.getPhone());
        tenant.setEmail(updatedTenant.getEmail());
        tenant.setDateOfBirth(updatedTenant.getDateOfBirth());
        tenant.setGender(updatedTenant.getGender());
        tenant.setEmergencyContact(updatedTenant.getEmergencyContact());
        tenant.setAddress(updatedTenant.getAddress());
        tenant.setMoveInDate(updatedTenant.getMoveInDate());
        tenant.setMoveOutDate(updatedTenant.getMoveOutDate());
        tenant.setRentAmount(updatedTenant.getRentAmount());
        tenant.setSecurityDeposit(updatedTenant.getSecurityDeposit());

        return tenantRepository.save(tenant);
    }

    public void deleteTenant(Long id) {

        Tenant tenant = getTenantById(id);

        Bed bed = tenant.getBed();

        if (bed != null) {
            bed.setStatus(BedStatus.AVAILABLE);
            bedRepository.save(bed);
        }

        tenantRepository.delete(tenant);
    }
}
