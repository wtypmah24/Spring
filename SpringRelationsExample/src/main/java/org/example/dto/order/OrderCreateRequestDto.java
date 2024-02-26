package org.example.dto.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.List;

public record OrderCreateRequestDto(
        @NotNull @Min(0) Long userId,
        @NotNull @NotEmpty (message = "Add at least one item") List<Long> itemIds
) { }
