package com.group_3.backen_project.models;

import jakarta.persistence.*;

@Entity
public class Categories_opportunities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categories;
}
