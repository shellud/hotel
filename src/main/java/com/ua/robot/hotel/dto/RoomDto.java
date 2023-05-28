package com.ua.robot.hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoomDto {

    private Long id;
    private int number;
    private String type;
    private int price;
    private List<Long> reservationId;
}
