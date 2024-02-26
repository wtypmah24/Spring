package org.example.dto;

import java.util.Set;

public record DishCreateRequestDto(long id, String name, Set<IngredientDto> ingredientsDto) {
}
