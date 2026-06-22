package com.itpu.internship.seats_reservation.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.itpu.internship.seats_reservation.utils.MovieFormat;
import com.itpu.internship.seats_reservation.utils.MovieLang;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@JsonPropertyOrder({"id", "movieId", "title", "date", "time", "language", "format"})
@Schema(description = "Movie session response model")
public class GetSessionDTO {

    @Schema(description = "Unique identifier of the session", example = "1")
    private Long id;

    @Schema(description = "ID of the associated movie", example = "42")
    private Long movieId;

    @Schema(description = "Display title of the session", example = "Inception – Evening Show")
    private String title;

    @Schema(description = "Date of the session (ISO 8601)", example = "2026-07-15")
    private LocalDate date;

    @Schema(description = "Start time of the session (ISO 8601)", example = "19:30:00")
    private LocalTime time;

    @Schema(description = "Language of the movie screening", example = "ENGLISH")
    private MovieLang language;

    @Schema(description = "Format of the movie screening", example = "TWO_D")
    private MovieFormat format;
}
