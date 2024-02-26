package org.example.dto.statistics;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record ClientAppStatisticDto(
        @Min(0) Long id,
        @Size(min = 1, max = 100, message = "Name length could be from 1 to 100 symbols") String clientAppName,
        @Min(0) long clientAppCount
) { }
