package com.devcloudy.exampleservice.service;

import com.devcloudy.exampleservice.repository.UsersRepository;
import com.devcloudy.exampleservice.user.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final UsersRepository repository;

    public void updateRole(String username, UserRole role) {
        repository.findByUsername(username).ifPresent(u -> {
                    log.info(u.getRole().toString());
                    u.setRole(role);
                    repository.save(u);
                    log.info(u.getUsername() + " теперь имеет роль " + u.getRole());
                });

    }
}
