package com.itpu.internship.seats_reservation.services;

import com.itpu.internship.seats_reservation.dtos.GetSeatDTO;
import com.itpu.internship.seats_reservation.dtos.SaveSeatDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SeatService {

    public GetSeatDTO createPlace(SaveSeatDTO saveSeatDTO) {
        return GetSeatDTO.builder().build();
    }

    public Page<GetSeatDTO> getAllPlaces(Pageable pageable) {
        return null;
    }

    public GetSeatDTO getPlace(Long id) {
        return GetSeatDTO.builder().build();
    }

    public GetSeatDTO updatePlace(Long id, SaveSeatDTO saveSeatDTO) {
        return GetSeatDTO.builder().build();
    }

    public void deletePlace(Long id) {
    }

}
