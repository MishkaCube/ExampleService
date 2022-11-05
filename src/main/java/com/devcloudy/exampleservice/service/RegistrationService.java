package com.devcloudy.exampleservice.service;

import com.devcloudy.exampleservice.mapper.UserMapper;
import com.devcloudy.exampleservice.repository.UsersRepository;
import com.devcloudy.exampleservice.user.RegistrationRequest;
import com.devcloudy.exampleservice.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UsersRepository repository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public void signUp(RegistrationRequest request) {
        boolean isUserExists =
                repository.findByUsername(request.getUsername())
                        .isPresent();
        if (isUserExists) {
            throw new IllegalStateException("Nickname is already taken");
        }
        request.setRole(UserRole.ROLE_USER);
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        request.setEnabled(true);
        repository.save(mapper.toUsers(request));
        
    }



}
