package org.example.service;

import org.example.guest.Guest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Service
@SessionScope
public class GuestService {
    private final Map<Long, Guest> idToGuest;
    private long count;

    public GuestService() {
        idToGuest = new HashMap<>();
        count = 1;
    }

    public Guest createGuest(String guestName) {
        Guest guest = new Guest(count++, guestName, 1);
        idToGuest.put(guest.id(), guest);
        return guest;
    }

    public void addOrder(long id) {
        Guest oldGuest = Optional.ofNullable(idToGuest.get(id)).orElseThrow();
        Guest newGuest = new Guest(id, oldGuest.name(), oldGuest.order() + 1);
        idToGuest.put(id, newGuest);
    }


}