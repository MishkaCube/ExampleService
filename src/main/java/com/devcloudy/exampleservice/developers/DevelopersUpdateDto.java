package com.devcloudy.exampleservice.developers;

import lombok.Data;

@Data
public class DevelopersUpdateDto {

    private String name;
    private String post;
    private String description;
    private String photo;

}
