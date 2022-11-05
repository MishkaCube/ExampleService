package com.devcloudy.exampleservice.repository;

import com.devcloudy.exampleservice.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Long> {

}