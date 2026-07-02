package com.itpu.internship.seats_reservation.services;

import com.itpu.internship.seats_reservation.dtos.GetSeatDTO;
import com.itpu.internship.seats_reservation.dtos.SaveSeatDTO;
import com.itpu.internship.seats_reservation.entities.HallEntity;
import com.itpu.internship.seats_reservation.entities.PriceCategoryEntity;
import com.itpu.internship.seats_reservation.entities.SeatEntity;
import com.itpu.internship.seats_reservation.mappers.SeatMapper;
import com.itpu.internship.seats_reservation.repositories.HallRepository;
import com.itpu.internship.seats_reservation.repositories.PriceCategoryRepository;
import com.itpu.internship.seats_reservation.repositories.SeatRepository;
import com.itpu.internship.seats_reservation.exceptions.SeatAlreadyExistsException;
import com.itpu.internship.seats_reservation.exceptions.SeatNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final HallRepository hallRepository;
    private final PriceCategoryRepository priceCategoryRepository;
    private final SeatMapper seatMapper;

    public GetSeatDTO createPlace(SaveSeatDTO saveSeatDTO) {
        log.info("Creating new seat with row={}, number={}, hallId={}", saveSeatDTO.getRow(), 
                 saveSeatDTO.getNumber(), saveSeatDTO.getHallId());

        // Check if seat with same hallId, row and number already exists
        Optional<SeatEntity> existingSeat = seatRepository.findByHallIdAndRowAndNumber(
                saveSeatDTO.getHallId(), 
                saveSeatDTO.getRow(), 
                saveSeatDTO.getNumber()
        );

        if (existingSeat.isPresent()) {
            String errorMessage = String.format(
                    "Seat with hallId=%d, row=%d, number=%d already exists",
                    saveSeatDTO.getHallId(), 
                    saveSeatDTO.getRow(), 
                    saveSeatDTO.getNumber()
            );
            log.error(errorMessage);
            throw new SeatAlreadyExistsException(errorMessage);
        }

        // Get hall by id
        HallEntity hall = hallRepository.findById(saveSeatDTO.getHallId())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Hall with id=%d not found", saveSeatDTO.getHallId());
                    log.error(errorMessage);
                    return new SeatNotFoundException(errorMessage);
                });

        // Get price category by id
        PriceCategoryEntity priceCategory = priceCategoryRepository.findById(saveSeatDTO.getPriceCategoryId())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Price category with id=%d not found", saveSeatDTO.getPriceCategoryId());
                    log.error(errorMessage);
                    return new SeatNotFoundException(errorMessage);
                });

        SeatEntity seatEntity = seatMapper.buildSeatEntity(saveSeatDTO, hall, priceCategory);
        SeatEntity savedSeat = seatRepository.save(seatEntity);
        log.info("Seat created successfully with id={}", savedSeat.getId());

        return seatMapper.toGetSeatDTO(savedSeat);
    }

    public Page<GetSeatDTO> getAllPlaces(Pageable pageable) {
        log.info("Fetching all seats with pagination: page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());
        Page<SeatEntity> seatPage = seatRepository.findAll(pageable);
        return new PageImpl<>(
                seatPage.getContent().stream()
                        .map(seatMapper::toGetSeatDTO)
                        .toList(),
                pageable,
                seatPage.getTotalElements()
        );
    }

    public GetSeatDTO getPlace(Long id) {
        log.info("Fetching seat with id={}", id);
        SeatEntity seatEntity = seatRepository.findById(id)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Seat with id=%d not found", id);
                    log.error(errorMessage);
                    return new SeatNotFoundException(errorMessage);
                });

        return seatMapper.toGetSeatDTO(seatEntity);
    }

    public GetSeatDTO updatePlace(Long id, SaveSeatDTO saveSeatDTO) {
        log.info("Updating seat with id={}", id);

        SeatEntity seatEntity = seatRepository.findById(id)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Seat with id=%d not found", id);
                    log.error(errorMessage);
                    return new SeatNotFoundException(errorMessage);
                });

        // Check if new row/number combination already exists for this hall (excluding current seat)
        Optional<SeatEntity> existingSeat = seatRepository.findByHallIdAndRowAndNumber(
                saveSeatDTO.getHallId(), 
                saveSeatDTO.getRow(), 
                saveSeatDTO.getNumber()
        );

        if (existingSeat.isPresent() && !existingSeat.get().getId().equals(id)) {
            String errorMessage = String.format(
                    "Seat with hallId=%d, row=%d, number=%d already exists",
                    saveSeatDTO.getHallId(), 
                    saveSeatDTO.getRow(), 
                    saveSeatDTO.getNumber()
            );
            log.error(errorMessage);
            throw new SeatAlreadyExistsException(errorMessage);
        }

        // Get price category if it changed
        if (!seatEntity.getPriceCategoryEntity().getId().equals(saveSeatDTO.getPriceCategoryId())) {
            PriceCategoryEntity priceCategory = priceCategoryRepository.findById(saveSeatDTO.getPriceCategoryId())
                    .orElseThrow(() -> {
                        String errorMessage = String.format("Price category with id=%d not found", saveSeatDTO.getPriceCategoryId());
                        log.error(errorMessage);
                        return new SeatNotFoundException(errorMessage);
                    });
            seatMapper.updateSeatEntity(seatEntity, saveSeatDTO, priceCategory);
        } else {
            // Get the existing price category to pass to mapper
            seatMapper.updateSeatEntity(seatEntity, saveSeatDTO, seatEntity.getPriceCategoryEntity());
        }

        SeatEntity updatedSeat = seatRepository.save(seatEntity);
        log.info("Seat with id={} updated successfully", id);

        return seatMapper.toGetSeatDTO(updatedSeat);
    }

    public void deletePlace(Long id) {
        log.info("Deleting seat with id={}", id);

        boolean exists = seatRepository.existsById(id);
        if (!exists) {
            String errorMessage = String.format("Seat with id=%d not found", id);
            log.error(errorMessage);
            throw new SeatNotFoundException(errorMessage);
        }

        seatRepository.deleteById(id);
        log.info("Seat with id={} deleted successfully", id);
    }
}
