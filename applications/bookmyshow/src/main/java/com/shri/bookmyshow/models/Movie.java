package com.shri.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String name;
    private LocalDate releaseDate;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;
}
