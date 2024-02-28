package com.example.hotelapp.dao;

import com.example.hotelapp.entity.Reservation;
import com.example.hotelapp.entity.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Component
public class HotelDaoImpl implements HotelDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Room> getAllRooms() {
        return entityManager.createQuery("SELECT r FROM Room r", Room.class).getResultList();
    }

    @Override
    @Transactional
    public List<Room> getAllAvailableRooms(LocalDate startDate, LocalDate endDate) {
        return getAllRooms().stream()
                .filter(room -> room.getReservations().stream()
                        .noneMatch(res -> !res.getStartDate().isBefore(startDate) &&
                                !res.getEndDate().isAfter(endDate))).toList();
    }

    @Override
    @Transactional
    public Reservation reserve(Reservation reservation) {
        Objects.requireNonNull(reservation, "You didn't provide reservation.");
        entityManager.persist(reservation);
        return reservation;
    }

    @Override
    @Transactional
    public void cancelReservation(long id) {
        entityManager.remove(findReservationById(id));
    }

    private Reservation findReservationById(long cancelId) {
        return entityManager.createQuery(
                        "SELECT r FROM Reservation r WHERE r.id=:cancelId", Reservation.class)
                .setParameter("cancelId", cancelId)
                .getSingleResult();
    }
}
