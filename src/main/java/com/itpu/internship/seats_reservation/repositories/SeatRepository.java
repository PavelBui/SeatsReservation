package com.itpu.internship.seats_reservation.repositories;

import com.itpu.internship.seats_reservation.entities.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
    @Query("SELECT s FROM SeatEntity s WHERE s.hallEntity.id = :hallId AND s.row = :row AND s.number = :number")
    Optional<SeatEntity> findByHallIdAndRowAndNumber(@Param("hallId") Long hallId, @Param("row") Integer row, @Param("number") Integer number);
}
