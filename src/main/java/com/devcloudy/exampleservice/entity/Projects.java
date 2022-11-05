package com.devcloudy.exampleservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Lob
    private String image;
    private String author;
    @Column(columnDefinition = "text")
    private String description;
    @Column(length = 1024)
    private String url;
    private LocalDate date;
}
