package com.webapp.webapp_be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webapp.webapp_be.models.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductDTO {
    private String name;
    private Float price;
    private String thumbnail;
    private String description;

    @JsonProperty("category_id")
    private Long categoryId;
}
