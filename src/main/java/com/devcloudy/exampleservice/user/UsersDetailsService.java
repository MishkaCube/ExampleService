package com.devcloudy.exampleservice.user;

import com.devcloudy.exampleservice.entity.Users;
import com.devcloudy.exampleservice.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UsersDetailsService implements UserDetailsService {

    private final UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = repository.findByUsername(username);


        if (users.isEmpty()) {
            throw new UsernameNotFoundException("This user is not present");
        }

        return new UsersDetails(users.get());
    }


}
