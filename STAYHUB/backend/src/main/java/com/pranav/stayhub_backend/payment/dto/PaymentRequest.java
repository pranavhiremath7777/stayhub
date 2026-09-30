package com.pranav.stayhub_backend.payment.dto;

import com.pranav.stayhub_backend.payment.PaymentMethod;
import com.pranav.stayhub_backend.payment.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentRequest {

    private BigDecimal amount;
    private LocalDate dueDate;
    private PaymentStatus status;
    private PaymentMethod paymentMethod;
    private String transactionReference;

    public PaymentRequest() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }
}
