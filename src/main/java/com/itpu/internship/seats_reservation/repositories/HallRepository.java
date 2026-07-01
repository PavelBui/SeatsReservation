package com.itpu.internship.seats_reservation.repositories;

import com.itpu.internship.seats_reservation.entities.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<HallEntity, Long> {
}
