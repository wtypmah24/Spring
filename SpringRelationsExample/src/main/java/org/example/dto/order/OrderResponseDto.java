package org.example.dto.order;

import java.time.LocalDate;
import java.util.List;

public record OrderResponseDto(
        Long id,
        LocalDate orderDate,
        Long userId,
        List<GoodsItemDto> items
) { }