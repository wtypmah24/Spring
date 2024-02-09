package org.example.service;

import org.example.dish.Dish;
import org.example.dish.Ingredient;
import org.example.dto.DishDto;
import org.example.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

@Service
public class ServiceMenu {
    private final Set<Dish> menu;
    private final DishMapper dishMapper;

    @Autowired
    public ServiceMenu(DishMapper dishMapper) {
        menu = new HashSet<>(Set.of(
                new Dish("French_Potato", Map.of(new Ingredient("Potato", 200, Duration.ofMinutes(20), 2.0), 400)),
                new Dish("Crumble_Eggs", Map.of(new Ingredient("Egg", 150, Duration.ofMinutes(10), 1.0), 200))
        ));
        this.dishMapper = dishMapper;
    }

    public DishDto getByName(String name) {
        Dish dish = menu.stream().filter(d -> Objects.equals(d.getName(), name)).findFirst().orElseThrow();
        return dishMapper.toDishDto(dish);
    }
}
