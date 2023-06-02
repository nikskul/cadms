package ru.nskul.cadms.financialflowcontrolservice.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nskul.cadms.financialflowcontrolservice.application.auth.AuthService;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserWithPasswordDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.request.LoginRequest;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

/**
 * Контроллер аутентификации.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthService service;

    /**
     * Авторизация.
     *
     * @param request
     * @return
     */
    @PostMapping("/login")
    public UserDto login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

    /**
     * Регистрация.
     *
     * @param user
     * @return
     */
    public BaseOperationResponse login(@RequestBody UserWithPasswordDto user) {
        return service.register(user);
    }

}
