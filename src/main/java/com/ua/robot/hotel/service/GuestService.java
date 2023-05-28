package com.ua.robot.hotel.service;

import com.ua.robot.hotel.domain.Guest;
import com.ua.robot.hotel.dto.GuestDto;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    List<GuestDto> getAllGuests();
    Guest getGuestById (Long id);
    Guest createGuest(Guest guest);
    void deleteGuestById (Long id);
    Optional<Guest> findByLastName(String lastName);
    Optional<Guest> findByPassportId(String passportId);
    void updateGuest(Long id, Guest guestToUpdate);
}
