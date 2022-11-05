package com.devcloudy.exampleservice.projects;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectsDto {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String description;
    private String url;
    private LocalDate date;

}
