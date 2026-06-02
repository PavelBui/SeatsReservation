package com.itpu.internship.seats_reservation.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.itpu.internship.seats_reservation.utils.SeatStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@JsonPropertyOrder({"id", "row", "number", "status", "isAvailable", "comment"})
public class GetSeatDTO {

    private Long id;

    private Integer row;

    private Integer number;

    private SeatStatus status;

    private Boolean isAvailable;

    private String comment;
}
