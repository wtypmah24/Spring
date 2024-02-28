package com.example.hotelapp.mapper;

import com.example.hotelapp.dao.HotelDao;
import com.example.hotelapp.dto.ReservationRequestDto;
import com.example.hotelapp.dto.ReservationResponseDto;
import com.example.hotelapp.dto.RoomDto;
import com.example.hotelapp.entity.Reservation;
import com.example.hotelapp.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {
    private final HotelDao hotelDao;
    private final RoomMapper roomMapper;
    @Autowired
    public ReservationMapper(HotelDao hotelDao, RoomMapper roomMapper) {
        this.hotelDao = hotelDao;
        this.roomMapper = roomMapper;
    }

    public Reservation toReservation(ReservationRequestDto reservationRequestDto){

        Set<Room> rooms = hotelDao.getAllRooms()
                .stream()
                .filter(room -> reservationRequestDto.roomNumbers().contains(room.getRoomNumber()))
                .collect(Collectors.toSet());

        return new Reservation(null, reservationRequestDto.customerName(),
                reservationRequestDto.startDate(),
                reservationRequestDto.endDate(),
                rooms);
    }

    public ReservationResponseDto toResponseDto(Reservation reservation){
        Set<RoomDto> roomDtos = reservation.getRooms().stream().map(roomMapper::toRoomDto).collect(Collectors.toSet());
        return new ReservationResponseDto(reservation.getCustomerName(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                roomDtos);
    }
}