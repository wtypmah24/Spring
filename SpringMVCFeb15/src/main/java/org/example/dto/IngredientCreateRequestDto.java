package org.example.dto;

import java.time.Duration;

public record IngredientDto(String name, int nutrition, Duration cookingTime, int price){

}
