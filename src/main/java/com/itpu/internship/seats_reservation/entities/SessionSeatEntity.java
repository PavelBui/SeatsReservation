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
@Table(name = "session_seats")
public class SessionSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false, updatable = false)
    private SessionEntity sessionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false, updatable = false)
    private SeatEntity seatEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SeatStatus status;

    @Column(name = "is_available")
    private String isAvailable;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact")
    private String contact;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        SessionSeatEntity sessionSeatEntity = (SessionSeatEntity) o;
        return id != null && Objects.equals(id, sessionSeatEntity.id) &&
                Objects.equals(sessionEntity, sessionSeatEntity.sessionEntity) &&
                Objects.equals(seatEntity, sessionSeatEntity.seatEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionEntity, seatEntity);
    }
}
