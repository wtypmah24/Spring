package com.example.hotelapp.controller;

import com.example.hotelapp.dto.ReservationRequestDto;
import com.example.hotelapp.dto.ReservationResponseDto;
import com.example.hotelapp.dto.RoomDto;
import com.example.hotelapp.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HotelController {
    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }
    @GetMapping("/rooms")
    public List<RoomDto> getAllRooms(){
        return service.getAllRooms();
    }

    @PostMapping("/reserve")
    public ReservationResponseDto reserve(@RequestBody ReservationRequestDto requestDto){
        return service.reserve(requestDto);
    }

    @GetMapping("/available")
    public List<RoomDto> getAvailableRooms(@RequestParam(value = "start", required = true) LocalDate start,
                                           @RequestParam(value = "end", required = true) LocalDate end){
        return service.getAvailableRooms(start, end);
    }

    @DeleteMapping("/rooms/cancel/{id}")
    public String cancelReservation(@PathVariable(name = "id") long id){
        return service.cancelReservation(id);
    }
}