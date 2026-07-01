package com.itpu.internship.seats_reservation.repositories;

import com.itpu.internship.seats_reservation.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
