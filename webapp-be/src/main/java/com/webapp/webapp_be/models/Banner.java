package com.webapp.webapp_be.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="banners")
@Getter
@Setter
@Builder
public class Banner extends BaseEntity {
    private Long id;

    private String title;

    private String subtitle;

    private String image;

    @Column(name="cta_text")
    private String ctaText;

    @Column(name="cta_link")
    private String ctaLink;

}
