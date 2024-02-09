package org.example.dish;

import java.time.Duration;

public record Ingredient(String name, int nutrition, Duration cookingTime, double price) {
}
