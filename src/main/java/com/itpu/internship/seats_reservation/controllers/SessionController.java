package com.itpu.internship.seats_reservation.controllers;

import com.itpu.internship.seats_reservation.dtos.GetSessionDTO;
import com.itpu.internship.seats_reservation.dtos.SaveSessionDTO;
import com.itpu.internship.seats_reservation.services.SessionService;
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
@RequestMapping("/sessions")
@Tag(name = "Sessions", description = "Endpoints for managing movie screening sessions")
public class SessionController {

    private final SessionService sessionService;

    @Operation(summary = "Create a new session", description = "Creates a new movie screening session and returns the saved object.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Session created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping
    @ResponseStatus(CREATED)
    public GetSessionDTO createSession(@RequestBody @Validated SaveSessionDTO saveSessionDTO) {
        return sessionService.createSession(saveSessionDTO);
    }

    @Operation(summary = "Get all sessions", description = "Returns a paginated list of all movie screening sessions.")
    @ApiResponse(responseCode = "200", description = "Page of sessions returned successfully")
    @GetMapping
    public Page<GetSessionDTO> getAllSessions(
            @PageableDefault(sort = {"startDateTime", "name"}, size = DEFAULT_PAGE_SIZE) Pageable pageable) {
        return sessionService.getAllSessions(pageable);
    }

    @Operation(summary = "Get a session by ID", description = "Returns a single movie session by its numeric ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Session found"),
            @ApiResponse(responseCode = "404", description = "Session not found")
    })
    @GetMapping("/{id}")
    public GetSessionDTO getSession(
            @Parameter(description = "Numeric ID of the session", required = true)
            @PathVariable(name = "id") Long id) {
        return sessionService.getSession(id);
    }

    @Operation(summary = "Update a session", description = "Updates an existing movie session by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Session updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Session not found")
    })
    @PutMapping("/{id}")
    public GetSessionDTO updateSession(
            @Parameter(description = "Numeric ID of the session to update", required = true)
            @PathVariable(name = "id") Long id,
            @RequestBody @Validated SaveSessionDTO saveSessionDTO) {
        return sessionService.updateSession(id, saveSessionDTO);
    }

    @Operation(summary = "Delete a session", description = "Deletes a movie session by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Session deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Session not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteSession(
            @Parameter(description = "Numeric ID of the session to delete", required = true)
            @PathVariable(name = "id") Long id) {
        sessionService.deleteSession(id);
    }
}
