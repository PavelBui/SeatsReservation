package com.itpu.internship.seats_reservation.repositories;

import com.itpu.internship.seats_reservation.entities.CinemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<CinemaEntity, Long> {

}
