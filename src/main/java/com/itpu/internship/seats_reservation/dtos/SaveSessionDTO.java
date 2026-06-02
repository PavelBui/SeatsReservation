package com.itpu.internship.seats_reservation.dtos;

import com.itpu.internship.seats_reservation.utils.MovieFormat;
import com.itpu.internship.seats_reservation.utils.MovieLang;
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
public class SaveSessionDTO {

    @NotNull
    private Long movieId;

    @Size(max = 150)
    private String title;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;

    private MovieLang language;

    private MovieFormat format;
}
