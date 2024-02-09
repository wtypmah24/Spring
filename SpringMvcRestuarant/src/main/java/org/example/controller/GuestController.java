package org.example.controller;

import org.example.guest.Guest;
import org.example.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/guests")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/create")
    public String createGuest(Model model) {
        model.addAttribute("guestDto", new Guest(0, "", 0));
        return "guest_registration";
    }

    @PostMapping("/create")
    public String postGuest(@ModelAttribute("guestDto") Guest guest, Model model) {
        if (guest.id() > 0) {
            guestService.addOrder(guest.id());
            model.addAttribute("name", guest.name());
            model.addAttribute("discount", guest.order() * 5);
            return "guest_welcome";
        }
        Guest createdGuest = guestService.createGuest(guest.name());
        model.addAttribute("guestDto", createdGuest);
        return "guest_create";
    }

}
