package com.shri.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private String referenceNumber;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

}
