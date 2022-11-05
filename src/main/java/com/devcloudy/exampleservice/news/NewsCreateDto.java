package com.devcloudy.exampleservice.news;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsCreateDto {

    private String image;
    private String title;
    private String description;
    private String text;
    private String subject;
    private LocalDate date;

}
