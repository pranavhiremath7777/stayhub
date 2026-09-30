package com.pranav.stayhub_backend.payment;

import com.pranav.stayhub_backend.tenant.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByTenantId(Long tenantId);

    List<Payment> findByTenant(Tenant tenant);
}
