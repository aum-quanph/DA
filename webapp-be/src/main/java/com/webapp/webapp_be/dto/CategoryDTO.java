package com.webapp.webapp_be.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CategoryDTO {
    private String name;
    private String description;
    private String image;
}
