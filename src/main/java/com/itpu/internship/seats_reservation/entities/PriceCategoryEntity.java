package com.itpu.internship.seats_reservation.entities;

import com.itpu.internship.seats_reservation.utils.PriceCategory;
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
@Table(name = "price_category")
public class PriceCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PriceCategory type;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        PriceCategoryEntity priceCategoryEntity = (PriceCategoryEntity) o;
        return id != null && Objects.equals(id, priceCategoryEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
