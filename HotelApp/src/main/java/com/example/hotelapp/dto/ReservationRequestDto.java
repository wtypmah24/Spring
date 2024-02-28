package com.example.hotelapp.dto;

import java.time.LocalDate;
import java.util.Set;

public record ReservationRequestDto(String customerName,
                                    LocalDate startDate,
                                    LocalDate endDate,
                                    Set<String> roomNumbers) {
}
