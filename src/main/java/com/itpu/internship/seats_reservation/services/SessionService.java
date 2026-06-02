package com.itpu.internship.seats_reservation.services;

import com.itpu.internship.seats_reservation.dtos.GetSessionDTO;
import com.itpu.internship.seats_reservation.dtos.SaveSessionDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SessionService {


    public GetSessionDTO createSession(SaveSessionDTO saveSessionDTO) {
        return GetSessionDTO.builder().build();
    }

    public Page<GetSessionDTO> getAllSessions(Pageable pageable) {
        return null;
    }

    public GetSessionDTO getSession(Long id) {
        return GetSessionDTO.builder().build();
    }

    public GetSessionDTO updateSession(Long id, SaveSessionDTO saveSessionDTO) {
        return GetSessionDTO.builder().build();
    }

    public void deleteSession(Long id) {
    }

}
