package com.group_3.backen_project.models;

import jakarta.persistence.*;

@Entity
public class Status_opportunities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
}
