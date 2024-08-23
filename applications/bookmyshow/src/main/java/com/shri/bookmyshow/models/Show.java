package com.shri.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private LocalTime startTime;
    private  LocalTime endTime;
    private Movie movie;
    private Theater theater;
    private Screen screen;
    private List<Features> features;
}
