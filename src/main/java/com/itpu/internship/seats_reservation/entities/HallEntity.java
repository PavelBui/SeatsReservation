package com.itpu.internship.seats_reservation.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "halls")
public class HallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", nullable = false, updatable = false)
    private CinemaEntity cinemaEntity;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        HallEntity hallEntity = (HallEntity) o;
        return id != null && Objects.equals(id, hallEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
