package com.ua.robot.hotel.service;

import com.ua.robot.hotel.dto.ReservationDto;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    void createReservation(Long roomId, Long guestId, LocalDate startDate, LocalDate endDate);
    List<ReservationDto> getAllReservations();
}
