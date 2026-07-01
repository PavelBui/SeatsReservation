package com.itpu.internship.seats_reservation.repositories;

import com.itpu.internship.seats_reservation.entities.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {
}
