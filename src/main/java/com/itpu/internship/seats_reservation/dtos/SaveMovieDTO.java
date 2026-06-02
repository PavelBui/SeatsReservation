package com.itpu.internship.seats_reservation.dtos;

import com.itpu.internship.seats_reservation.utils.AgeRating;
import com.itpu.internship.seats_reservation.utils.Genre;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class SaveMovieDTO {

    @Size(max = 150)
    @NonFinal
    private String title;

    @NotNull
    private Integer durationMinutes;

    private AgeRating ageRating;

    private Float rating;

    private String posterUrl;

    private String description;

    private Set<Genre> genres;

    private Integer releaseYear;
}
