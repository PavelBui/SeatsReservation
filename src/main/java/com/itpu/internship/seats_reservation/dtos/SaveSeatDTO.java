package com.itpu.internship.seats_reservation.dtos;

import com.itpu.internship.seats_reservation.utils.SeatStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class SaveSeatDTO {

    @NotNull
    private Integer row;

    @NotNull
    private Integer number;

    private SeatStatus status;

    @NotNull
    private Boolean isAvailable;

    private String comment;
}
