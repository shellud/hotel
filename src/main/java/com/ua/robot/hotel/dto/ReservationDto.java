package com.ua.robot.hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ReservationDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomNumber;
    private String guestPassportId;
}
