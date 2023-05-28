package com.ua.robot.hotel.service;

import com.ua.robot.hotel.domain.Reservation;
import com.ua.robot.hotel.domain.Room;
import com.ua.robot.hotel.dto.RoomDto;
import com.ua.robot.hotel.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(RoomServiceImpl::buildRoomDto)
                .collect(Collectors.toList());
    }

    private static RoomDto buildRoomDto(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .number(room.getNumber())
                .type(room.getType())
                .price(room.getPrice())
                .reservationId(room.getReservationList().stream()
                        .map(Reservation::getId)
                        .collect(Collectors.toList()))
                .build();
    }
    @Override
    public Room getRoomById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.orElse(null);
    }

    @Override
    @Transactional
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateRoom(Long id, Room roomToUpdate) {
        roomToUpdate.setId(id);
        roomRepository.save(roomToUpdate);
    }
}
