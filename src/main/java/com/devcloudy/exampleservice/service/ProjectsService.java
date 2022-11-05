package com.devcloudy.exampleservice.service;

import com.devcloudy.exampleservice.entity.Projects;
import com.devcloudy.exampleservice.mapper.ProjectsMapper;
import com.devcloudy.exampleservice.projects.ProjectsCreateDto;
import com.devcloudy.exampleservice.projects.ProjectsDto;
import com.devcloudy.exampleservice.projects.ProjectsUpdateDto;
import com.devcloudy.exampleservice.repository.ProjectsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectsService {

    private final ProjectsRepository repository;
    private final ProjectsMapper mapper;
    private static final int DEFAULT_PAGE_SIZE = 10;

    public List<ProjectsDto> getProjects(Integer limit) {
        return repository.findAll(PageRequest.of(0, limit == null ? DEFAULT_PAGE_SIZE : limit)).stream()
                .map(mapper::projectToProjectDto).collect(Collectors.toList());
    }

    public ProjectsDto getProjectById(Long id) {
        return mapper.projectToProjectDto(repository.findById(id).orElse(null));
    }

    public ProjectsDto create(ProjectsCreateDto request) {
        Projects projects = mapper.toProject(request);
        projects.setAuthor("DevCloudy");
        log.info(projects.getAuthor() + " creating a project...");
        repository.save(projects);
        return mapper.projectToProjectDto(projects);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ProjectsDto update(ProjectsUpdateDto request, Long id) {
        Projects projects = mapper.projectUpdateRequestToProjectView(request, id);
        repository.save(projects);
        return mapper.projectToProjectDto(projects);
    }


}
