package org.example.controller;

import org.example.dto.DishDto;
import org.example.service.ServiceMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/menu")
public class DishController {
    private final ServiceMenu serviceMenu;

    @Autowired
    public DishController(ServiceMenu serviceMenu) {
        this.serviceMenu = serviceMenu;
    }

    @GetMapping("/dishes")
    public DishDto getDish(@RequestParam(name = "name", required = true) String name) {
        return serviceMenu.getByName(name);
    }
}
