package bday.app.friend;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record Friend(@NotBlank @Size(min = 1, message = "Name must contain at least one letter.") String firstName,
                     @NotBlank @Size(min = 1, message = "Name must contain at least one letter.") String lastName,
                     @PastOrPresent LocalDate birthDate) {
}