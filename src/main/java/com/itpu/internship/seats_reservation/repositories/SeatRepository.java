package com.itpu.internship.seats_reservation.repositories;

import com.itpu.internship.seats_reservation.entities.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
}
