package com.example.hotelapp.dao;

import com.example.hotelapp.entity.Reservation;
import com.example.hotelapp.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface HotelDao {
    List<Room> getAllRooms();
    List<Room> getAllAvailableRooms(LocalDate startDate, LocalDate endDate);
    Reservation reserve(Reservation reservation);
    void cancelReservation(long id);
}
