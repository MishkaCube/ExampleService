package com.devcloudy.exampleservice.posts;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostsCreateDto {
    private String image;
    private String title;
    private LocalDate date;
    private String text;
}
