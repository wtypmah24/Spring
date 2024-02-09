package org.example.mapper;

import org.example.dish.Dish;
import org.example.dto.DishDto;
import org.springframework.stereotype.Component;

@Component
public class DishMapper {
    public DishDto toDishDto(Dish dish) {
        return new DishDto(dish.getName(),
                dish.getIngredientsToWeight().keySet(),
                dish.calculateTime().toMinutes(),
                dish.calculatePrice(),
                dish.calculateNutrition());
    }
}
