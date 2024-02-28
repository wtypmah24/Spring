package com.example.hotelapp.service;

import com.example.hotelapp.dao.HotelDao;
import com.example.hotelapp.dto.ReservationRequestDto;
import com.example.hotelapp.dto.ReservationResponseDto;
import com.example.hotelapp.dto.RoomDto;
import com.example.hotelapp.mapper.ReservationMapper;
import com.example.hotelapp.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService {
    private final RoomMapper roomMapper;
    private final ReservationMapper reservationMapper;
    private final HotelDao hotelDao;

    @Autowired
    public HotelService(RoomMapper roomMapper, ReservationMapper reservationMapper, HotelDao hotelDao) {
        this.roomMapper = roomMapper;
        this.reservationMapper = reservationMapper;
        this.hotelDao = hotelDao;
    }

    public List<RoomDto> getAllRooms() {
        return hotelDao.getAllRooms().stream().map(roomMapper::toRoomDto).toList();
    }

    public ReservationResponseDto reserve(ReservationRequestDto reservationRequestDto) {
        return reservationMapper
                .toResponseDto(hotelDao
                        .reserve(reservationMapper
                                .toReservation(reservationRequestDto)));
    }

    public List<RoomDto> getAvailableRooms(LocalDate start, LocalDate end){
        return hotelDao.getAllAvailableRooms(start, end).stream()
                .map(roomMapper::toRoomDto).toList();
    }

    public String cancelReservation(long id){
        hotelDao.cancelReservation(id);
        return "Your reservation is canceled";
    }
}
