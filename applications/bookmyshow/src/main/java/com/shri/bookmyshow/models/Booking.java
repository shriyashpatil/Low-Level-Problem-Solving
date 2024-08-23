package com.shri.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private String bookingNumber;
    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;
    private double amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}
