package com.pranav.stayhub_backend.payment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pranav.stayhub_backend.common.exception.ResourceNotFoundException;
import com.pranav.stayhub_backend.tenant.Tenant;
import com.pranav.stayhub_backend.tenant.TenantRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final TenantRepository tenantRepository;

    public PaymentService(
            PaymentRepository paymentRepository,
            TenantRepository tenantRepository) {

        this.paymentRepository = paymentRepository;
        this.tenantRepository = tenantRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {

        return paymentRepository.findById(id)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Payment not found"));
    }

    public List<Payment> getPaymentsByTenant(Long tenantId) {

        if (!tenantRepository.existsById(tenantId)) {
            throw new ResourceNotFoundException("Tenant not found");
        }

        return paymentRepository.findByTenantId(tenantId);
    }

    public Payment createPayment(Long tenantId, Payment payment) {

        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Tenant not found"));

        payment.setTenant(tenant);

        if (payment.getStatus() == null) {
            payment.setStatus(PaymentStatus.PENDING);
        }

        return paymentRepository.save(payment);
    }

    public Payment markAsPaid(
            Long id,
            PaymentMethod paymentMethod,
            String transactionReference) {

        Payment payment = getPaymentById(id);

        payment.setStatus(PaymentStatus.PAID);
        payment.setPaymentDate(LocalDate.now());
        payment.setPaymentMethod(paymentMethod);
        payment.setTransactionReference(transactionReference);

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {

        Payment payment = getPaymentById(id);

        paymentRepository.delete(payment);
    }
}
