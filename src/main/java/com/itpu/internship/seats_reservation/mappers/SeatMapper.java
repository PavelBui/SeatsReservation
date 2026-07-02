package com.itpu.internship.seats_reservation.mappers;

import com.itpu.internship.seats_reservation.dtos.GetSeatDTO;
import com.itpu.internship.seats_reservation.dtos.SaveSeatDTO;
import com.itpu.internship.seats_reservation.entities.HallEntity;
import com.itpu.internship.seats_reservation.entities.PriceCategoryEntity;
import com.itpu.internship.seats_reservation.entities.SeatEntity;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public GetSeatDTO toGetSeatDTO(SeatEntity seatEntity) {
        return GetSeatDTO.builder()
                .id(seatEntity.getId())
                .row(seatEntity.getRow())
                .number(seatEntity.getNumber())
                .status(seatEntity.getStatus())
                .comment(seatEntity.getComment())
                .build();
    }

    public SeatEntity buildSeatEntity(SaveSeatDTO saveSeatDTO, HallEntity hall, PriceCategoryEntity priceCategory) {
        // Build and save seat entity
        return SeatEntity.builder()
                .hallEntity(hall)
                .priceCategoryEntity(priceCategory)
                .row(saveSeatDTO.getRow())
                .number(saveSeatDTO.getNumber())
                .status(saveSeatDTO.getStatus())
                .comment(saveSeatDTO.getComment())
                .build();
    }

    public void updateSeatEntity(SeatEntity seatEntity, SaveSeatDTO saveSeatDTO, PriceCategoryEntity priceCategory) {
        // Update seat fields
        seatEntity.setRow(saveSeatDTO.getRow());
        seatEntity.setNumber(saveSeatDTO.getNumber());
        seatEntity.setStatus(saveSeatDTO.getStatus());
        seatEntity.setComment(saveSeatDTO.getComment());
        seatEntity.setPriceCategoryEntity(priceCategory);
    }
}

