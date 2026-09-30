package com.pranav.stayhub_backend.payment.dto;

import com.pranav.stayhub_backend.payment.Payment;
import com.pranav.stayhub_backend.payment.PaymentMethod;
import com.pranav.stayhub_backend.payment.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentResponse {

    private Long id;
    private Long tenantId;
    private String tenantName;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private PaymentStatus status;
    private PaymentMethod paymentMethod;
    private String transactionReference;

    public PaymentResponse(Payment payment) {
        this.id = payment.getId();
        this.tenantId = payment.getTenant().getId();
        this.tenantName = payment.getTenant().getName();
        this.amount = payment.getAmount();
        this.dueDate = payment.getDueDate();
        this.paymentDate = payment.getPaymentDate();
        this.status = payment.getStatus();
        this.paymentMethod = payment.getPaymentMethod();
        this.transactionReference = payment.getTransactionReference();
    }

    public Long getId() {
        return id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public String getTransactionReference() {
        return transactionReference;
    }
}
