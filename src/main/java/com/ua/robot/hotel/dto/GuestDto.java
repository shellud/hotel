package com.ua.robot.hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GuestDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String passportId;
    private Long phoneNumber;
    private List<Long> reservationId;
}
