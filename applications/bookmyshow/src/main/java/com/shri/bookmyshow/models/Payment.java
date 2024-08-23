package com.shri.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private String referenceNumber;
    private double amount;
    private PaymentProvider paymentProvider;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;

}
