package com.devcloudy.exampleservice.controllers;

import com.devcloudy.exampleservice.posts.PostsCreateDto;
import com.devcloudy.exampleservice.posts.PostsDto;
import com.devcloudy.exampleservice.posts.PostsUpdateDto;
import com.devcloudy.exampleservice.service.PostsService;
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
@RequiredArgsConstructor
@RequestMapping("api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostsController {

    private final PostsService service;

    @PostMapping(value = "/create")
    public ResponseEntity<PostsDto> createNew(@Parameter(description = "Запрос на создание поста")
                                              @Valid @RequestBody PostsCreateDto request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<PostsDto>> getPosts(
            @Min(0) @Max(20)
            @RequestParam(value = "limit", required = false) Integer limit
    ) {
        return ResponseEntity.ok(service.getPosts(limit));
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<PostsDto> getNewById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPostById(id));
    }

    @DeleteMapping(value = "/get/{id}")
    public ResponseEntity<Void> deletePost(@PositiveOrZero @PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(
            value = "/update/{id}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<PostsDto> updateNews(
            @Parameter(description = "Идентификатор поста", required = true)
            @PositiveOrZero @PathVariable("id") Long id,
            @Parameter(description = "Запрос на обновление поста")
            @Valid @RequestBody(required = false) PostsUpdateDto request) {
        return ResponseEntity.ok(service.update(request, id));
    }

}
