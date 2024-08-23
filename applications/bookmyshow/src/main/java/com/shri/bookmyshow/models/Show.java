package com.shri.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity(name="shows")
public class Show extends BaseModel{
    private LocalTime startTime;
    private  LocalTime endTime;
    @ManyToOne
    private Movie movie;
//    private Theater theater;
    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;
}
