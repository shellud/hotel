package com.ua.robot.hotel.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int number;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int price;

    @OneToMany (mappedBy = "room")
    private List <Reservation> reservationList;
}
