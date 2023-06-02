package ru.nskul.cadms.financialflowcontrolservice.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nskul.cadms.financialflowcontrolservice.application.auth.AuthService;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.dto.UserWithPasswordDto;
import ru.nskul.cadms.financialflowcontrolservice.presentation.request.LoginRequest;
import ru.nskul.cadms.financialflowcontrolservice.presentation.response.BaseOperationResponse;

/**
 * Контроллер аутентификации.
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1", produces = "application/json")
public class AuthController {

    private final AuthService service;

    /**
     * Авторизация.
     *
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request) {
        var user = service.login(request);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(user);
    }

    /**
     * Регистрация.
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public BaseOperationResponse register(@RequestBody UserWithPasswordDto user) {
        return service.register(user);
    }

}
