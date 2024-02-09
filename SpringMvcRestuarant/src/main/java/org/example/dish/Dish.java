package org.example.dish;

import java.time.Duration;
import java.util.Comparator;
import java.util.Map;

public class Dish {
    private final String name;
    private final Map<Ingredient, Integer> ingredientsToWeight;

    public Dish(String name, Map<Ingredient, Integer> ingredientsToWeight) {
        this.name = name;
        this.ingredientsToWeight = ingredientsToWeight;
    }

    public double calculatePrice(){
        return ingredientsToWeight.entrySet().stream().mapToDouble(p -> p.getValue() * p.getKey().price()).sum();
    }

    public int calculateNutrition(){
        return ingredientsToWeight.entrySet().stream().mapToInt(p -> p.getValue() * p.getKey().nutrition()).sum();
    }
    public Duration calculateTime(){
        return ingredientsToWeight.keySet().stream().map(Ingredient::cookingTime).max(Comparator.naturalOrder()).orElseThrow();
        //return ingredientsToWeight.keySet().stream().max(Comparator.comparing(Ingredient::cookingTime)).orElseThrow().cookingTime();
    }

    public String getName() {
        return name;
    }

    public Map<Ingredient, Integer> getIngredientsToWeight() {
        return ingredientsToWeight;
    }
}
