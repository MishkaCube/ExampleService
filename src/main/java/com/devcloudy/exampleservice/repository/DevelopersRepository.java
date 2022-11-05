package com.devcloudy.exampleservice.repository;

import com.devcloudy.exampleservice.entity.Developers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopersRepository extends JpaRepository<Developers, Long> {
}