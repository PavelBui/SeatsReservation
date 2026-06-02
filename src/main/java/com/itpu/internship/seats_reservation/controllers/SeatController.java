package com.itpu.internship.seats_reservation.controllers;

import com.itpu.internship.seats_reservation.dtos.GetSeatDTO;
import com.itpu.internship.seats_reservation.dtos.SaveSeatDTO;
import com.itpu.internship.seats_reservation.services.SeatService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.itpu.internship.seats_reservation.utils.Constants.DEFAULT_PAGE_SIZE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@AllArgsConstructor
@RequestMapping("/places")
@Api(tags = "Place Endpoints")
public class SeatController {

    private final SeatService seatService;

    @PostMapping
    @ResponseStatus(CREATED)
    public GetSeatDTO createPlace(@RequestBody @Validated SaveSeatDTO saveSeatDTO) {
        return seatService.createPlace(saveSeatDTO);
    }

    @GetMapping
    public Page<GetSeatDTO> getAllPlaces(
            @PageableDefault(sort = {"row", "number"}, size = DEFAULT_PAGE_SIZE) Pageable pageable) {
        return seatService.getAllPlaces(pageable);
    }

    @GetMapping("/{id}")
    public GetSeatDTO getPlace(@PathVariable(name = "id") Long id) {
        return seatService.getPlace(id);
    }

    @PutMapping("/{id}")
    public GetSeatDTO updatePlace(
            @PathVariable(name = "id") Long id,
            @RequestBody @Validated SaveSeatDTO saveSeatDTO) {
        return seatService.updatePlace(id, saveSeatDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletePlace(@PathVariable(name = "id") Long id) {
        seatService.deletePlace(id);
    }

}
