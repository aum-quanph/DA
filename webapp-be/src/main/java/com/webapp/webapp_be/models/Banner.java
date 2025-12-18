package com.webapp.webapp_be.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="banners")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Banner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;

    private String image;

    @Column(name="cta_text")
    private String ctaText;

    @Column(name="cta_link")
    private String ctaLink;

}
