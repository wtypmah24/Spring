package org.example.mapper;

import org.example.dto.order.OrderResponseDto;
import org.example.dto.user.ExtendedUserResponseDto;
import org.example.dto.user.UserCreateRequestDto;
import org.example.dto.user.UserFormData;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.registration.RegistrationDto;
import org.example.dto.user.settings.SettingsDto;
import org.example.entity.user.User;
import org.example.entity.user.registration.Registration;
import org.example.entity.user.settings.Settings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {
    public User toUserCreateRequestDto(UserCreateRequestDto userResponseDto) {
        return User.builder()
                .firstName(userResponseDto.firstName())
                .lastName(userResponseDto.lastName())
                .birthDate(userResponseDto.birthDate())
                .email(userResponseDto.email())
                .build();
    }

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthDate(), user.getEmail());
    }

    public UserCreateRequestDto toUserCreateRequestDto(UserFormData userForm) {
        return new UserCreateRequestDto(
                userForm.getFirstName(),
                userForm.getLastName(),
                userForm.getBirthDate(),
                userForm.getEmail()
        );
    }

    public ExtendedUserResponseDto toExtendedUserResponseDto(User user, List<OrderResponseDto> orders) {
        return new ExtendedUserResponseDto(
                toUserResponseDto(user),
                toRegistrationDto(user.getRegistration()),
                toSettingsDto(user.getSettings()),
                orders
        );
    }

    public RegistrationDto toRegistrationDto(Registration registration) {
        return registration == null ? null : new RegistrationDto(
                registration.getUserId(),
                registration.getRegistrationDate(),
                registration.getConfirmationMethod()
        );
    }

    public SettingsDto toSettingsDto(Settings settings) {
        return settings == null ? null : new SettingsDto(settings.isDarkTheme(), settings.isSaveHistory(), settings.getNickname());
    }
}
