package com.itpu.internship.seats_reservation.entities;

import com.itpu.internship.seats_reservation.utils.SeatStatus;
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
@Table(name = "seats")
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id", nullable = false, updatable = false)
    private HallEntity hallEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_category_id", nullable = false, updatable = false)
    private PriceCategoryEntity priceCategoryEntity;

    @Column(name = "row")
    private Integer row;

    @Column(name = "number")
    private Integer number;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SeatStatus status;

    @Column(name = "comment")
    private String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        SeatEntity seatEntity = (SeatEntity) o;
        return id != null && Objects.equals(id, seatEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
