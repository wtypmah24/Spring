package org.example.dto;

import org.example.dish.Ingredient;

import java.util.Set;

public record DishDto (String name, Set<Ingredient> ingredients, long cookingTime, double price, int nutrition){
}
