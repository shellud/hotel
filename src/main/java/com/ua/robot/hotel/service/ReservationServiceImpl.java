package com.ua.robot.hotel.service;

import com.ua.robot.hotel.domain.Guest;
import com.ua.robot.hotel.domain.Reservation;
import com.ua.robot.hotel.domain.Room;
import com.ua.robot.hotel.dto.ReservationDto;
import com.ua.robot.hotel.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final RoomService roomService;
    private final GuestService guestService;
    private final ReservationRepository reservationRepository;
    @Override
    @Transactional
    public void createReservation(Long roomId, Long guestId, LocalDate startDate, LocalDate endDate) {
        Room room = roomService.getRoomById(roomId);
        Guest guest = guestService.getGuestById(guestId);
        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setGuest(guest);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservationRepository.save(reservation);
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationServiceImpl::buildReservationDto)
                .collect(Collectors.toList());
    }

    private static ReservationDto buildReservationDto(Reservation reservation){
        var roomNumber = 0;
        var guestPassportId = "NO GUEST";
        if (reservation.getRoom() != null) {
            roomNumber = reservation.getRoom().getNumber();
        }
        if (reservation.getGuest() != null) {
            guestPassportId = reservation.getGuest().getPassportId();
        }
        return ReservationDto.builder()
                .id(reservation.getId())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .roomNumber(roomNumber)
                .guestPassportId(guestPassportId)
                .build();

    }
}
