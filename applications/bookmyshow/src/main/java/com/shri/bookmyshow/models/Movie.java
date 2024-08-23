package com.shri.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String name;
    private LocalDate releaseDate;
}
