package com.ua.robot.hotel.service;

import com.ua.robot.hotel.domain.Guest;
import com.ua.robot.hotel.domain.Reservation;
import com.ua.robot.hotel.dto.GuestDto;
import com.ua.robot.hotel.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService{

    private final GuestRepository guestRepository;
    @Override
    public List<GuestDto> getAllGuests() {
        return guestRepository.findAll()
                .stream()
                .map(GuestServiceImpl::buildGuestDto)
                .collect(Collectors.toList());
    }

    private static GuestDto buildGuestDto(Guest guest) {
        return GuestDto.builder()
                .id(guest.getId())
                .firstName(guest.getFirstName())
                .lastName(guest.getLastName())
                .passportId(guest.getPassportId())
                .phoneNumber(guest.getPhoneNumber())
                .reservationId(guest.getReservationList().stream()
                        .map(Reservation::getId)
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public Guest getGuestById(Long id) {
        Optional<Guest> optionalGuest = guestRepository.findById(id);
        if(optionalGuest.isEmpty()){
            throw new IllegalStateException("Guest with id " + id + " does not exist");
        }
        return optionalGuest.get();
    }

    @Override
    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public void deleteGuestById(Long id) {
        guestRepository.deleteById(id);
    }

    public Optional<Guest> findByLastName(String lastName) {
        return guestRepository.findGuestByLastName(lastName);
    }

    public Optional<Guest> findByPassportId(String passportId) {
        return guestRepository.findGuestByPassportId(passportId);
    }

    @Override
    public void updateGuest(Long id, Guest guestToUpdate) {
        guestToUpdate.setId(id);
        guestRepository.save(guestToUpdate);
    }
}
