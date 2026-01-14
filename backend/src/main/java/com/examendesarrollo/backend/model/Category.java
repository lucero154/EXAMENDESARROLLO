package com.examendesarrollo.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
