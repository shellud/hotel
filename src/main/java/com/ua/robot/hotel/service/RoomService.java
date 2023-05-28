package com.ua.robot.hotel.service;

import com.ua.robot.hotel.domain.Room;
import com.ua.robot.hotel.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> getAllRooms();
    Room getRoomById (Long id);
    Room createRoom(Room room);
    void deleteRoomById (Long id);
    void updateRoom(Long id, Room roomToUpdate);
}
