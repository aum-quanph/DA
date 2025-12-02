package com.webapp.webapp_be.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="products")
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class Product extends BaseEntity {
    private Long id;

    private String name;

    private Float price;

    private String thumbnail;

    private String description;

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Long categoryId;
}
