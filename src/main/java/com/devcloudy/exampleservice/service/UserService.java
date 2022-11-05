package com.devcloudy.exampleservice.service;

import com.devcloudy.exampleservice.mapper.UserMapper;
import com.devcloudy.exampleservice.repository.UsersRepository;
import com.devcloudy.exampleservice.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository repository;
    private final UserMapper mapper;

    public List<UserDto> getUsers() {
        return repository.findAll().stream()
                .map((mapper::userToUserDto)).collect(Collectors.toList());
    }

}
