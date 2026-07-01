package com.itpu.internship.seats_reservation.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.itpu.internship.seats_reservation.utils.SeatStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@JsonPropertyOrder({"id", "session", "place", "status", "isAvailable", "customerName", "contact"})
@Schema(description = "Session-seat reservation response model")
public class GetSessionSeatDTO {

    @Schema(description = "Unique identifier of the reservation", example = "1")
    private Long id;

    @Schema(description = "Session linked to this reservation")
    private GetSessionDTO session;

    @Schema(description = "Seat/place linked to this reservation")
    private GetSeatDTO place;

    @Schema(description = "Status of the seat within the session", example = "ACTIVE")
    private SeatStatus status;

    @Schema(description = "Name of the customer who reserved the seat", example = "John Doe")
    private String customerName;

    @Schema(description = "Contact information of the customer", example = "+998901234567")
    private String contact;
}
