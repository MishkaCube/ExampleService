package com.devcloudy.exampleservice.news;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class NewsDto {

    private Long id;
    private String image;
    private String title;
    private String description;
    private String text;
    private String subject;
    private LocalDate date;

}
