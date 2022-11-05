package com.devcloudy.exampleservice.controllers;

import com.devcloudy.exampleservice.projects.ProjectsCreateDto;
import com.devcloudy.exampleservice.projects.ProjectsDto;
import com.devcloudy.exampleservice.projects.ProjectsUpdateDto;
import com.devcloudy.exampleservice.service.ProjectsService;
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
@RequestMapping("api/projects")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectsController {

    private final ProjectsService service;

    @PostMapping(value = "/create")
    public ResponseEntity<ProjectsDto> createProject(@Parameter(description = "Запрос на создание проекта")
                                              @Valid @RequestBody ProjectsCreateDto request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<ProjectsDto>> getProject(
            @Min(0) @Max(20)
            @RequestParam(value = "limit", required = false) Integer limit
    ) {
        return ResponseEntity.ok(service.getProjects(limit));
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ProjectsDto> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProjectById(id));
    }

    @DeleteMapping(value = "/get/{id}")
    public ResponseEntity<Void> deleteProject(@PositiveOrZero @PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(
            value = "/update/{id}",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<ProjectsDto> updateProject(
            @Parameter(description = "Идентификатор проекта", required = true)
            @PositiveOrZero @PathVariable("id") Long id,
            @Parameter(description = "Запрос на обновление проекта")
            @Valid @RequestBody(required = false) ProjectsUpdateDto request) {
        return ResponseEntity.ok(service.update(request, id));
    }




}
