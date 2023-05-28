package com.ua.robot.hotel.controller;

import com.ua.robot.hotel.domain.Guest;
import com.ua.robot.hotel.dto.GuestDto;
import com.ua.robot.hotel.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping
    public List<GuestDto> getAllGuests(){
        return guestService.getAllGuests();
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<Guest> findByLastName(@PathVariable String lastName) {
        return guestService.findByLastName(lastName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pass/{passportId}")
    public ResponseEntity<Guest> findByPassportId(@PathVariable String passportId) {
        return guestService.findByPassportId(passportId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Guest createGuest (@RequestBody Guest guest){
        return guestService.createGuest(guest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        guestService.deleteGuestById(id);
    }

    @PatchMapping("/{id}")
    public void updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        guestService.updateGuest(id, guest);
    }
}
