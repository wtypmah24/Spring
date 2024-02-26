package org.example.dto.user.registration;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.example.entity.user.registration.ConfirmationMethod;

import java.time.LocalDate;

public record RegistrationDto(
        @Min(0) Long userId,
        @PastOrPresent LocalDate registrationDate,
        @NotNull ConfirmationMethod confirmationMethod
        ) { }
