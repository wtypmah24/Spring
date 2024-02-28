package com.example.hotelapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "bed_number")
    private int bedNumber;
    @ManyToMany(mappedBy = "rooms")
    private Set<Reservation> reservations;
}
