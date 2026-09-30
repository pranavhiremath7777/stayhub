package com.pranav.stayhub_backend.payment;

import com.pranav.stayhub_backend.payment.dto.PaymentRequest;
import com.pranav.stayhub_backend.payment.dto.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public List<PaymentResponse> getAllPayments() {
        return paymentService.getAllPayments()
                .stream()
                .map(PaymentResponse::new)
                .toList();
    }

    @GetMapping("/payments/{id}")
    public PaymentResponse getPayment(@PathVariable Long id) {
        return new PaymentResponse(paymentService.getPaymentById(id));
    }

    @GetMapping("/tenants/{tenantId}/payments")
    public List<PaymentResponse> getPaymentsByTenant(
            @PathVariable Long tenantId) {

        return paymentService.getPaymentsByTenant(tenantId)
                .stream()
                .map(PaymentResponse::new)
                .toList();
    }

    @PostMapping("/tenants/{tenantId}/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse createPayment(
            @PathVariable Long tenantId,
            @RequestBody PaymentRequest request) {

        Payment payment = new Payment();

        payment.setAmount(request.getAmount());
        payment.setDueDate(request.getDueDate());
        payment.setStatus(request.getStatus());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setTransactionReference(request.getTransactionReference());

        return new PaymentResponse(
                paymentService.createPayment(tenantId, payment)
        );
    }

    @PutMapping("/payments/{id}/paid")
    public PaymentResponse markAsPaid(
            @PathVariable Long id,
            @RequestParam PaymentMethod paymentMethod,
            @RequestParam(required = false) String transactionReference) {

        return new PaymentResponse(
                paymentService.markAsPaid(
                        id,
                        paymentMethod,
                        transactionReference
                )
        );
    }

    @DeleteMapping("/payments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
