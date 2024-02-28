package com.example.hotelapp.dto;

import com.example.hotelapp.entity.Room;

import java.time.LocalDate;
import java.util.Set;

public record ReservationResponseDto(String customerName,
                                     LocalDate startDate,
                                     LocalDate endDate,
                                     Set<RoomDto> rooms) {
}
