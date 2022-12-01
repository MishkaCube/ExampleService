package com.devcloudy.exampleservice.service;

import com.devcloudy.exampleservice.user.RegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class RegistrationServiceTest {
    @Autowired
    private RegistrationService registrationService;


    @Test
    void shouldCreateUser() {
        RegistrationRequest user = RegistrationRequest.builder()
                .photo("photo")
                .email("email")
                .username("hello")
                .password("20205780")
                .name("Michael")
                .build();

        boolean isUserCreated = registrationService.signUp(user);
        Assert.assertTrue(isUserCreated);
    }
 }