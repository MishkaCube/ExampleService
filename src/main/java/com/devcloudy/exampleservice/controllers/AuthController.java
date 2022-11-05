package com.devcloudy.exampleservice.controllers;

import com.devcloudy.exampleservice.configuration.JwtUtil;
import com.devcloudy.exampleservice.service.RegistrationService;
import com.devcloudy.exampleservice.user.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/registration")
@RequiredArgsConstructor
public class AuthController {

    private final RegistrationService registrationService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public Map<String, String> register(@RequestBody RegistrationRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        registrationService.signUp(request);
        return Map.of("jwt", token);
    }

    @GetMapping("verifyToken")
    public Map<String, String> verifyToken(@RequestParam String token) {
        return Map.of("username of this token", jwtUtil.validateTokenAndRetrieveClaim(token));
    }

}
