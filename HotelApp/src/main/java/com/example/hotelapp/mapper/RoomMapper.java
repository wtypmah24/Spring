package com.example.hotelapp.mapper;

import com.example.hotelapp.dto.RoomDto;
import com.example.hotelapp.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public RoomDto toRoomDto(Room room){
        return new com.example.hotelapp.dto.RoomDto(room.getRoomNumber(), room.getPrice(), room.getDescription(), room.getBedNumber());
    }
}
