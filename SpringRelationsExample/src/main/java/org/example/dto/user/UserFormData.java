package org.example.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public final class UserFormData {
    @NotNull @Size(min = 1, max = 100, message = "Name length could be from 1 to 100 symbols")
    private String firstName;
    @NotNull @Size(min = 1, max = 100, message = "Last name length could be from 1 to 100 symbols")
    private String lastName;
    @Past(message = "Date of birth must be in the past")
    private LocalDate birthDate;

    @Email(message = "Email not correct")
    private String email;
}
