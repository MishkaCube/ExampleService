package com.devcloudy.exampleservice.controllers;

import com.devcloudy.exampleservice.user.UserDto;
import com.devcloudy.exampleservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping(value = "api/users")
    @Operation(description = "Создание тестового администратора (по умолчанию никнейм всегда admin)")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserDto> getUsers() {
        return service.getUsers();
    }

}
