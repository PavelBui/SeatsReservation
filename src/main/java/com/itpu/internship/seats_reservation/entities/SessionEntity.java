package com.itpu.internship.seats_reservation.entities;

import com.itpu.internship.seats_reservation.utils.MovieFormat;
import com.itpu.internship.seats_reservation.utils.MovieLang;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "sessions")
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false, updatable = false)
    private MovieEntity movieEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id", nullable = false, updatable = false)
    private HallEntity hallEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private MovieLang language;

    @Enumerated(EnumType.STRING)
    @Column(name = "format")
    private MovieFormat format;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        SessionEntity sessionEntity = (SessionEntity) o;
        return id != null && Objects.equals(id, sessionEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
