package com.webapp.webapp_be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Float price;
    private Float discount;
    private String thumbnail;
    private String description;

    @JsonProperty("category_id")
    private Long categoryId;
}
