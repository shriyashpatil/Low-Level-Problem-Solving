package com.shri.bookmyshow.services;

import com.shri.bookmyshow.models.Show;
import com.shri.bookmyshow.models.ShowSeat;
import com.shri.bookmyshow.models.ShowSeatType;
import com.shri.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {

    @Autowired
    ShowSeatTypeRepository showSeatTypeRepository;

    public double calculatePrice(Show show, List<ShowSeat> showSeats){
        double amount = 0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findByShow(show);
        for(ShowSeat showSeat : showSeats){
            for(ShowSeatType seatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(seatType.getSeatType())){
                    amount += seatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }

}
