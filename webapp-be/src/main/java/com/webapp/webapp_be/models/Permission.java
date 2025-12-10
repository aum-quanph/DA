package com.webapp.webapp_be.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="permissions")
public class Permission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;
}
