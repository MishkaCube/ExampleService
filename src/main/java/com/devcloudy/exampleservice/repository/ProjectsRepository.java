package com.devcloudy.exampleservice.repository;

import com.devcloudy.exampleservice.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends PagingAndSortingRepository<Projects, Long> {

}