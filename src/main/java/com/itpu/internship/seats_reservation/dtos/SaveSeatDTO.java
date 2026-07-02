package com.itpu.internship.seats_reservation.dtos;

import com.itpu.internship.seats_reservation.utils.SeatStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
@Schema(description = "Request model for creating or updating a cinema seat/place")
public class SaveSeatDTO {

    @NotNull
    @Schema(description = "ID of the hall containing this seat", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long hallId;

    @NotNull
    @Schema(description = "ID of the price category for this seat", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long priceCategoryId;

    @NotNull
    @Schema(description = "Row number of the seat in the hall", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer row;

    @NotNull
    @Schema(description = "Seat number within the row", example = "15", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer number;

    @Schema(description = "Status of the seat", example = "ACTIVE", allowableValues = {"ACTIVE", "DEACTIVATED"})
    private SeatStatus status;

    @Schema(description = "Optional comment about the seat", example = "VIP seat")
    private String comment;
}
