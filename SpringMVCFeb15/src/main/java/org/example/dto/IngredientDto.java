package org.example.entity.dish;

import java.time.Duration;

public record Ingredient (String name,int nutrition, Duration cookingTime, int price){

}
