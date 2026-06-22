package com.itpu.internship.seats_reservation.controllers;

import com.itpu.internship.seats_reservation.dtos.GetSeatDTO;
import com.itpu.internship.seats_reservation.dtos.SaveSeatDTO;
import com.itpu.internship.seats_reservation.services.SeatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Places", description = "Endpoints for managing cinema seats (places)")
public class SeatController {

    private final SeatService seatService;

    @Operation(summary = "Create a new place", description = "Creates a new cinema seat/place and returns the saved object.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Place created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping
    @ResponseStatus(CREATED)
    public GetSeatDTO createPlace(@RequestBody @Validated SaveSeatDTO saveSeatDTO) {
        return seatService.createPlace(saveSeatDTO);
    }

    @Operation(summary = "Get all places", description = "Returns a paginated list of all cinema seats.")
    @ApiResponse(responseCode = "200", description = "Page of places returned successfully")
    @GetMapping
    public Page<GetSeatDTO> getAllPlaces(
            @PageableDefault(sort = {"row", "number"}, size = DEFAULT_PAGE_SIZE) Pageable pageable) {
        return seatService.getAllPlaces(pageable);
    }

    @Operation(summary = "Get a place by ID", description = "Returns a single cinema seat by its numeric ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Place found"),
            @ApiResponse(responseCode = "404", description = "Place not found")
    })
    @GetMapping("/{id}")
    public GetSeatDTO getPlace(
            @Parameter(description = "Numeric ID of the place", required = true)
            @PathVariable(name = "id") Long id) {
        return seatService.getPlace(id);
    }

    @Operation(summary = "Update a place", description = "Updates an existing cinema seat by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Place updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Place not found")
    })
    @PutMapping("/{id}")
    public GetSeatDTO updatePlace(
            @Parameter(description = "Numeric ID of the place to update", required = true)
            @PathVariable(name = "id") Long id,
            @RequestBody @Validated SaveSeatDTO saveSeatDTO) {
        return seatService.updatePlace(id, saveSeatDTO);
    }

    @Operation(summary = "Delete a place", description = "Deletes a cinema seat by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Place deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Place not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletePlace(
            @Parameter(description = "Numeric ID of the place to delete", required = true)
            @PathVariable(name = "id") Long id) {
        seatService.deletePlace(id);
    }
}
