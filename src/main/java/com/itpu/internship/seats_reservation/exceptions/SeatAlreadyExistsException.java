package com.itpu.internship.seats_reservation.exceptions;

public class SeatAlreadyExistsException extends RuntimeException {
    public SeatAlreadyExistsException(String message) {
        super(message);
    }

    public SeatAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

