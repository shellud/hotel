package com.ua.robot.hotel.controller;

import com.ua.robot.hotel.domain.Room;
import com.ua.robot.hotel.dto.RoomDto;
import com.ua.robot.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public List<RoomDto> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        roomService.deleteRoomById(id);
    }

    @PatchMapping("/{id}")
    public void updateRoom(@PathVariable Long id, @RequestBody Room room) {
        roomService.updateRoom(id, room);
    }
}
