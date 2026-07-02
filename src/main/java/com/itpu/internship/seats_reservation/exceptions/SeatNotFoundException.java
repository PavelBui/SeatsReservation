package com.itpu.internship.seats_reservation.exceptions;

public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(String message) {
        super(message);
    }

    public SeatNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

