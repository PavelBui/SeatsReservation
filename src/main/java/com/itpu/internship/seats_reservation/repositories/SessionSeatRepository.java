package com.itpu.internship.seats_reservation.repositories;

import com.itpu.internship.seats_reservation.entities.SessionSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionSeatRepository extends JpaRepository<SessionSeatEntity, Long> {
}
