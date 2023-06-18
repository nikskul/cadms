package ru.nskul.cadms.financialflowcontrolservice.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.nskul.cadms.financialflowcontrolservice.application.user.UserService;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserDto;

import java.util.List;
import java.util.UUID;

/**
 * API пользователей.
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public final class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.getAll();
    }

}
