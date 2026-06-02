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
@JsonPropertyOrder({"id", "session", "place", "status", "isAvailable", "customerName", "contact"})
public class GetSessionSeatDTO {

    private Long id;

    private GetSessionDTO session;

    private GetSeatDTO place;

    private SeatStatus status;

    private String isAvailable;

    private String customerName;

    private String contact;
}
