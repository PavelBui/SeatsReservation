package com.itpu.internship.seats_reservation.controllers;

import com.itpu.internship.seats_reservation.dtos.GetSessionDTO;
import com.itpu.internship.seats_reservation.dtos.SaveSessionDTO;
import com.itpu.internship.seats_reservation.services.SessionService;
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
@RequestMapping("/sessions")
@Api(tags = "Session Endpoints")
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    @ResponseStatus(CREATED)
    public GetSessionDTO createSession(@RequestBody @Validated SaveSessionDTO saveSessionDTO) {
        return sessionService.createSession(saveSessionDTO);
    }

    @GetMapping
    public Page<GetSessionDTO> getAllSessions(
            @PageableDefault(sort = {"startDateTime", "name"}, size = DEFAULT_PAGE_SIZE) Pageable pageable) {
        return sessionService.getAllSessions(pageable);
    }

    @GetMapping("/{id}")
    public GetSessionDTO getSession(@PathVariable(name = "id") Long id) {
        return sessionService.getSession(id);
    }

    @PutMapping("/{id}")
    public GetSessionDTO updateSession(
            @PathVariable(name = "id") Long id,
            @RequestBody @Validated SaveSessionDTO saveSessionDTO) {
        return sessionService.updateSession(id, saveSessionDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteSession(@PathVariable(name = "id") Long id) {
        sessionService.deleteSession(id);
    }

}
