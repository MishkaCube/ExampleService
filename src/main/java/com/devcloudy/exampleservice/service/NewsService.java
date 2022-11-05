package com.devcloudy.exampleservice.service;

import com.devcloudy.exampleservice.entity.News;
import com.devcloudy.exampleservice.mapper.NewsMapper;
import com.devcloudy.exampleservice.news.NewsCreateDto;
import com.devcloudy.exampleservice.news.NewsDto;
import com.devcloudy.exampleservice.news.NewsUpdateDto;
import com.devcloudy.exampleservice.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {

    private final NewsRepository repository;
    private final NewsMapper mapper;

    private static final int DEFAULT_PAGE_SIZE = 10;


    public List<NewsDto> getNews(Integer limit) {
        return repository.findAll(PageRequest.of(0, limit == null ? DEFAULT_PAGE_SIZE : limit)).stream()
                .map(mapper::newsToNewsDto).collect(Collectors.toList());
    }

    public List<NewsDto> getNewsById(Long id) {
        return repository.findById(id).stream().map(mapper::newsToNewsDto).collect(Collectors.toList());
    }

    public NewsDto create(NewsCreateDto dto) {
        News news = mapper.toNews(dto);
        log.info("Creating new");
        repository.save(news);
        return mapper.newsToNewsDto(news);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public NewsDto update(Long id, NewsUpdateDto request) {
        News news = mapper.newsUpdateRequestToNewsView(request, id);
        repository.save(news);
        return mapper.newsToNewsDto(news);
    }


}
