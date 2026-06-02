package com.itpu.internship.seats_reservation.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.itpu.internship.seats_reservation.utils.MovieFormat;
import com.itpu.internship.seats_reservation.utils.MovieLang;
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
public class GetSessionDTO {

    private Long id;

    private Long movieId;

    private String title;

    private LocalDate date;

    private LocalTime time;

    private MovieLang language;

    private MovieFormat format;
}
