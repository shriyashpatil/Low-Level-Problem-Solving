package com.shri.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private String bookingNUmber;
    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    private double amount;
    private List<Payment> payments;
    private BookingStatus bookingStatus;
}
