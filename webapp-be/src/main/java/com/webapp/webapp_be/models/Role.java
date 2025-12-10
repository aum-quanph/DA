package com.webapp.webapp_be.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="roles")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
