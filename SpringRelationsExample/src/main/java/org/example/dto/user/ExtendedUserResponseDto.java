package org.example.dto.user;

import org.example.dto.order.OrderResponseDto;
import org.example.dto.user.registration.RegistrationDto;
import org.example.dto.user.settings.SettingsDto;

import java.util.List;

public record ExtendedUserResponseDto(
        UserResponseDto user,
        RegistrationDto registrationDto,
        SettingsDto settings,
        List<OrderResponseDto> orders
) { }
