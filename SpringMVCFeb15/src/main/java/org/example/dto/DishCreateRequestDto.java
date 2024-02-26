package org.example.dto;

import org.example.entity.dish.Ingredient;

import java.util.List;
import java.util.Map;
import java.util.Set;

public record DishDto(long id, String name, Set<IngredientDto> ingredientsDto) {
}
