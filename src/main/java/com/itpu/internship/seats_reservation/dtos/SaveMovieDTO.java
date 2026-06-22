package com.itpu.internship.seats_reservation.dtos;

import com.itpu.internship.seats_reservation.utils.AgeRating;
import com.itpu.internship.seats_reservation.utils.Genre;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Request model for creating or updating a movie")
public class SaveMovieDTO {

    @Size(max = 150)
    @NonFinal
    @Schema(description = "Title of the movie (max 150 chars)", example = "Inception", maxLength = 150)
    private String title;

    @NotNull
    @Schema(description = "Duration of the movie in minutes", example = "148", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer durationMinutes;

    @Schema(description = "Age rating of the movie", example = "PG_13", allowableValues = {"G", "PG", "PG_13", "R", "NC_17"})
    private AgeRating ageRating;

    @Schema(description = "Average audience rating (0.0 – 10.0)", example = "8.8")
    private Float rating;

    @Schema(description = "URL to the movie poster image", example = "https://example.com/posters/inception.jpg")
    private String posterUrl;

    @Schema(description = "Short description or synopsis of the movie")
    private String description;

    @Schema(description = "Set of genres for the movie")
    private Set<Genre> genres;

    @Schema(description = "Year the movie was released", example = "2010")
    private Integer releaseYear;
}
