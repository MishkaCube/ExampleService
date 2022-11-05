package com.devcloudy.exampleservice.controllers;

import com.devcloudy.exampleservice.news.NewsCreateDto;
import com.devcloudy.exampleservice.news.NewsDto;
import com.devcloudy.exampleservice.news.NewsUpdateDto;
import com.devcloudy.exampleservice.service.NewsService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {

    private final NewsService service;

    @PostMapping(value = "/create")
    public ResponseEntity<NewsDto> createNew(@Parameter(description = "Запрос на создание новости")
                                             @Valid @RequestBody NewsCreateDto request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<NewsDto>> getNews(
                                            @Min(0) @Max(20)
                                            @RequestParam(value = "limit", required = false) Integer limit
    ) {
        return ResponseEntity.ok(service.getNews(limit));
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<List<NewsDto>> getNewById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getNewsById(id));
    }

    @DeleteMapping(value = "/get/{id}")
    public ResponseEntity<Void> deleteNews(@PositiveOrZero @PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(
            value = "/update/{id}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<NewsDto> updateNews(
            @Parameter(description = "Идентификатор задачи", required = true)
            @PositiveOrZero @PathVariable("id") Long id,
            @Parameter(description = "Запрос на обновление задачи")
            @Valid @RequestBody(required = false) NewsUpdateDto request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}
