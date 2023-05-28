package com.ua.robot.hotel.controller;

import com.ua.robot.hotel.dto.ReservationDto;
import com.ua.robot.hotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public List<ReservationDto> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @PostMapping("/reservations/{roomId}/{guestId}/{startDate}/{endDate}")
    public void createReservation(@PathVariable("roomId") Long roomId,
                                         @PathVariable("guestId") Long guestId,
                                         @PathVariable("startDate") LocalDate startDate,
                                         @PathVariable("endDate") LocalDate endDate) {
        reservationService.createReservation(roomId, guestId, startDate, endDate);
    };
}
