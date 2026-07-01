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
@JsonPropertyOrder({"id", "row", "number", "status", "isAvailable", "comment"})
@Schema(description = "Cinema seat/place response model")
public class GetSeatDTO {

    @Schema(description = "Unique identifier of the seat", example = "1")
    private Long id;

    @Schema(description = "Row number of the seat in the hall", example = "3")
    private Integer row;

    @Schema(description = "Seat number within the row", example = "15")
    private Integer number;

    @Schema(description = "Current status of the seat", example = "ACTIVE")
    private SeatStatus status;

    @Schema(description = "Optional comment about the seat (e.g. damaged, reserved)", example = "VIP seat")
    private String comment;
}
