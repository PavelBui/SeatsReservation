package com.itpu.internship.seats_reservation.repositories;

import com.itpu.internship.seats_reservation.entities.PriceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceCategoryRepository extends JpaRepository<PriceCategoryEntity, Long> {
}
