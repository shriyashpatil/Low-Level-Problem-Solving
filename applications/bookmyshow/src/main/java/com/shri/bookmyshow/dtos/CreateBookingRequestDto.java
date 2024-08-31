package com.shri.bookmyshow.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {

    private Long userId;
    private Long showId; /// can be skipped as we have show seat ids , but we have take for convenience
    private List<Long> showSeatIds;
}
