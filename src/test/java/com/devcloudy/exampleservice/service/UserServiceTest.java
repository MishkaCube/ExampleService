package com.devcloudy.exampleservice.service;

import com.devcloudy.exampleservice.entity.Users;
import com.devcloudy.exampleservice.mapper.UserMapper;
import com.devcloudy.exampleservice.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@Slf4j
class UserServiceTest {
    @Mock
    private UsersRepository repository;
    @Mock
    private UserMapper mapper;
    private AutoCloseable autoCloseable;
    private UserService userService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(repository, mapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void shouldGetAllUsers() {
        userService.getUsers();
        verify(repository).findAll();
    }
}