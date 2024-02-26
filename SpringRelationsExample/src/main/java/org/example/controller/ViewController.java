package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.dto.user.UserResponseDto;
import org.example.dto.user.UserFormData;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@Controller
@RequestMapping(path = "/view")
public class ViewController {
    private final UserService userService;
    private final UserMapper userMapper;


    @Autowired
    public ViewController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/profile/{userId}")
    public String getProfileView(@PathVariable("userId") @PositiveOrZero long userId, Model model) {
        UserResponseDto userResponseDto = userService.getUser(userId);
        model.addAttribute("id", userResponseDto.id());
        model.addAttribute("firstName", userResponseDto.firstName());
        model.addAttribute("lastName", userResponseDto.lastName());
        model.addAttribute(
                "age",
                userResponseDto.birthDate() == null ? "" : Period.between(userResponseDto.birthDate(), LocalDate.now()).getYears()
        );
        model.addAttribute("email", userResponseDto.email() != null ? userResponseDto.email() : "");
        return "user_profile";
    }

    @GetMapping("register")
    public String getRegisterForm(Model model) {
        model.addAttribute("userForm", new UserFormData());
        return "user_registration";
    }

    @PostMapping("register")
    public String register(
            @ModelAttribute("userForm") @Valid UserFormData userForm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "user_registration";
        }
        UserResponseDto newUserResponseDto = userService.createUser(userMapper.toUserCreateRequestDto(userForm));
        model.addAttribute("userForm", userForm);
        model.addAttribute("newUser", newUserResponseDto);
        return "user_registered";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

    @GetMapping("/profile/{userId}/edit")
    public String getEditProfileForm(@PathVariable("userId") @PositiveOrZero long userId, Model model) {
        UserResponseDto userResponseDto = userService.getUser(userId);
        UserFormData userFormData = new UserFormData();
        userFormData.setFirstName(userResponseDto.firstName());
        userFormData.setLastName(userResponseDto.lastName());
        userFormData.setBirthDate(userResponseDto.birthDate());
        userFormData.setEmail(userResponseDto.email());
        model.addAttribute("editForm", userFormData);
        model.addAttribute("userId", userId);
        return "user_profile_edit";
    }

    @PutMapping("/profile/{userId}/edit")
    public String editProfile(
            @PathVariable("userId") @PositiveOrZero long userId,
            @ModelAttribute("editForm") @Valid UserFormData editForm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "user_profile_edit";
        }
        UserResponseDto updatedUserDtoResponseDto = userService.updateUser(userId, userMapper.toUserCreateRequestDto(editForm));
        model.addAttribute("updatedUser", updatedUserDtoResponseDto);
        return "user_profile_edit_success";
    }
}
