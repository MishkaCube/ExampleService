package com.devcloudy.exampleservice.mapper;

import com.devcloudy.exampleservice.entity.Users;
import com.devcloudy.exampleservice.user.RegistrationRequest;
import com.devcloudy.exampleservice.user.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(Users entity);
    Users toUsers(RegistrationRequest request);

}
