package com.devcloudy.exampleservice.repository;

import com.devcloudy.exampleservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    Optional<Users> findByUsername(String username);
//    @Query("select count(e)>0 from Users e where e.email = ?1")
//    Boolean existsByEmail(String email);
}
