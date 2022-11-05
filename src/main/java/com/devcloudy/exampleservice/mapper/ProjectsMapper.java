package com.devcloudy.exampleservice.mapper;

import com.devcloudy.exampleservice.entity.Projects;
import com.devcloudy.exampleservice.projects.ProjectsCreateDto;
import com.devcloudy.exampleservice.projects.ProjectsDto;
import com.devcloudy.exampleservice.projects.ProjectsUpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectsMapper {

    Projects toProject(ProjectsCreateDto dto);
    ProjectsDto projectToProjectDto(Projects entity);
    Projects projectUpdateRequestToProjectView(ProjectsUpdateDto dto, Long id);

}
