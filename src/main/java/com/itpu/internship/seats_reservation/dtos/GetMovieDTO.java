package com.itpu.internship.seats_reservation.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.itpu.internship.seats_reservation.utils.AgeRating;
import com.itpu.internship.seats_reservation.utils.Genre;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@JsonPropertyOrder({"id", "title", "durationMinutes", "ageRating", "rating", "posterUrl", "description", "genres", "releaseYear"})
public class GetMovieDTO {

    private Long id;

    private String title;

    private Integer durationMinutes;

    private AgeRating ageRating;

    private Float rating;

    private String posterUrl;

    private String description;

    private Set<Genre> genres;

    private Integer releaseYear;
}
