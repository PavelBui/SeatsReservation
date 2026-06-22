package com.itpu.internship.seats_reservation.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.itpu.internship.seats_reservation.utils.AgeRating;
import com.itpu.internship.seats_reservation.utils.Genre;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Movie response model")
public class GetMovieDTO {

    @Schema(description = "Unique identifier of the movie", example = "42")
    private Long id;

    @Schema(description = "Title of the movie", example = "Inception")
    private String title;

    @Schema(description = "Duration of the movie in minutes", example = "148")
    private Integer durationMinutes;

    @Schema(description = "Age rating of the movie", example = "PG_13")
    private AgeRating ageRating;

    @Schema(description = "Average audience rating (0.0 – 10.0)", example = "8.8")
    private Float rating;

    @Schema(description = "URL to the movie poster image", example = "https://example.com/posters/inception.jpg")
    private String posterUrl;

    @Schema(description = "Short description or synopsis of the movie", example = "A thief who steals corporate secrets through dream-sharing technology.")
    private String description;

    @Schema(description = "Set of genres associated with the movie")
    private Set<Genre> genres;

    @Schema(description = "Year the movie was released", example = "2010")
    private Integer releaseYear;
}
