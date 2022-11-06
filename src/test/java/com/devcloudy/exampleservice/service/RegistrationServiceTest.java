//package com.devcloudy.exampleservice.service;
//
//import com.devcloudy.exampleservice.entity.Users;
//import com.devcloudy.exampleservice.mapper.UserMapper;
//import com.devcloudy.exampleservice.repository.UsersRepository;
//import com.devcloudy.exampleservice.user.RegistrationRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@Slf4j
//class RegistrationServiceTest {
//    @Autowired
//    private RegistrationService registrationService;
//
//    @MockBean
//    private UsersRepository repository;
//    @MockBean
//    private UserMapper mapper;
//    @MockBean
//    private BCryptPasswordEncoder passwordEncoder;
//    @MockBean
//    RegistrationRequest request;
//
//    @Test
//    @Disabled
//    void shouldCreateUser() {
//
//        Users users = new Users();
//        boolean isUserCreated = registrationService.signUp(request);
//        log.info(request.getUsername());
//        Assert.assertTrue(isUserCreated);
//
//    }
// }