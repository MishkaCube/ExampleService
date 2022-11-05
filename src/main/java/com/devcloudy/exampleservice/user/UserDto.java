package com.devcloudy.exampleservice.user;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String photo;
    private String name;
    private String username;
    private String password;
    private String email;
    private UserRole role;
    private boolean enabled;
}
