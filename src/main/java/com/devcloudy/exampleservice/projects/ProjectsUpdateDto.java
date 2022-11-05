package com.devcloudy.exampleservice.projects;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectsUpdateDto {

    private String title;
    private String image;
    private String description;
    private String url;
    private LocalDate date;

}
