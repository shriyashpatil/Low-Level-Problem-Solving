package com.shri.bookmyshow.services;

import com.shri.bookmyshow.exceptions.SeatNotAvailableException;
import com.shri.bookmyshow.exceptions.ShowNotFoundException;
import com.shri.bookmyshow.exceptions.UserNotFoundException;
import com.shri.bookmyshow.models.*;

import com.shri.bookmyshow.repositories.BookingRepository;
import com.shri.bookmyshow.repositories.ShowRepository;
import com.shri.bookmyshow.repositories.ShowSeatRepository;
import com.shri.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PriceCalculator priceCalculator;


    /*
            1. Get the user with the given userId
            2. Get the show with given showId
            3. Get the List of Show Seats with the given id's
            ---------- TAKE A LOCK--------------------------
            4. Check If all the seats are available or not.
            5. if not, throw exception.
            6. if yes, Mark the status of all the seats as BLOCKED
            7. Save the changes i the Db as well
            ------- ---------- RELEASE THE LOCK ---------------------
            8. Create the booking with pending status.
            9. Return the booking object
         */
    @Transactional(isolation= Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, List<Long> showSeatIds, Long showId) throws UserNotFoundException,ShowNotFoundException, SeatNotAvailableException {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isEmpty()){
            throw new UserNotFoundException("User with id: "+userId+" not found");
        }
        User user = optional.get();
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new ShowNotFoundException("Show with id: "+showId+" not found");
        }
        Show show = showOptional.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
                throw new SeatNotAvailableException("Seat is blocked");
        }
        for (ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
        }
        showSeatRepository.saveAll(showSeats);
        return saveBooking(user,show,showSeats);
    }


    private Booking saveBooking(User user, Show show, List<ShowSeat> showSeats){
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBookingNumber("auto-generate");
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShow(show);
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);
        booking.setAmount(priceCalculator.calculatePrice(show,showSeats));

        return bookingRepository.save(booking);
    }

}
