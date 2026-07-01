package com.itpu.internship.seats_reservation.entities;

import com.itpu.internship.seats_reservation.utils.AgeRating;
import com.itpu.internship.seats_reservation.utils.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_rating")
    private AgeRating ageRating;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "description")
    private String description;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Set<Genre> genres;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        MovieEntity movieEntity = (MovieEntity) o;
        return id != null && Objects.equals(id, movieEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
