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
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String passportId;

    @Column(nullable = false)
    private Long phoneNumber;

    @OneToMany (mappedBy = "guest")
    private List<Reservation> reservationList;
}
