package com.shri.bookmyshow.controllers;

import com.shri.bookmyshow.dtos.CreateBookingRequestDto;
import com.shri.bookmyshow.dtos.CreateBookingResponseDto;
import com.shri.bookmyshow.dtos.ResponseStatus;
import com.shri.bookmyshow.models.Booking;
import com.shri.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Controller should return DTOs it should not work on concrete object
    public CreateBookingResponseDto createBooking(CreateBookingRequestDto createBookingRequestDto){

        CreateBookingResponseDto createBookingResponseDto = new CreateBookingResponseDto();

        try{
            Booking booking = bookingService.createBooking(createBookingRequestDto.getUserId(),
                    createBookingRequestDto.getShowSeatIds(),
                    createBookingRequestDto.getShowId());

            createBookingResponseDto.setBookingId(booking.getId());
            createBookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }catch(Exception e){
            createBookingResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return createBookingResponseDto;
    }

}
