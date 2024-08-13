package models;

import java.time.LocalDateTime;

public class Payment extends BaseModel{

    private Double amount;

    private Mode mode;

    private PaymentStatus paymentStatus;

    private String referenceNo;

}
