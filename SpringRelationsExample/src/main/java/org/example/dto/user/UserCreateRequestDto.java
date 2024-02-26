package org.example.dto.user;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserCreateRequestDto(
        @Size(min = 1, max = 100, message = "Name length could be from 1 to 100 symbols") String firstName,
        @Size(min = 1, max = 100, message = "Last name length could be from 1 to 100 symbols") String lastName,
        @Past(message = "Date of birth must be in the past") LocalDate birthDate,
        @NotBlank @Email String email
) { }
