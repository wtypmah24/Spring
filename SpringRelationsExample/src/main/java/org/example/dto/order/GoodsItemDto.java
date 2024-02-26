package org.example.dto.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record GoodsItemDto(
        @Min(0) Long id,
        @Size(min = 1, max = 100, message = "Item name length could be from 1 to 100 symbols") String itemName,
        @Size(min = 1, max = 100, message = "Description name length could be from 1 to 100 symbols") String description,
        @Positive BigDecimal price
) { }
