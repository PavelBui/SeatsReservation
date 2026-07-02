package com.itpu.internship.seats_reservation.exceptions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonPropertyOrder({"timestamp", "status", "message", "error"})
@Schema(description = "Error response model")
public class ErrorResponse {

    @Schema(description = "Timestamp when the error occurred", example = "2026-07-02T10:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP status code", example = "404")
    private Integer status;

    @Schema(description = "Error message", example = "Seat not found")
    private String message;

    @Schema(description = "Error type", example = "SeatNotFoundException")
    private String error;
}

