package com.itpu.internship.seats_reservation.dtos;

import com.itpu.internship.seats_reservation.utils.MovieFormat;
import com.itpu.internship.seats_reservation.utils.MovieLang;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Schema(description = "Request model for creating or updating a movie session")
public class SaveSessionDTO {

    @NotNull
    @Schema(description = "ID of the movie to link to this session", example = "42", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long movieId;

    @Size(max = 150)
    @Schema(description = "Display title for the session (max 150 chars)", example = "Inception – Evening Show", maxLength = 150)
    private String title;

    @NotNull
    @Schema(description = "Date of the session (ISO 8601)", example = "2026-07-15", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate date;

    @NotNull
    @Schema(description = "Start time of the session (ISO 8601)", example = "19:30:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalTime time;

    @Schema(description = "Language of the screening", example = "ENGLISH", allowableValues = {"ENGLISH", "RUSSIAN", "UZBEK"})
    private MovieLang language;

    @Schema(description = "Format of the screening", example = "TWO_D", allowableValues = {"TWO_D", "THREE_D", "IMAX"})
    private MovieFormat format;
}
