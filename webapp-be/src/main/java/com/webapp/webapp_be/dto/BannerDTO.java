package com.webapp.webapp_be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BannerDTO {
    private String title;

    private String subtitle;

    private String image;

    @JsonProperty("cta_text")
    private String ctaText;

    @JsonProperty("cta_link")
    private String ctaLink;
}
