package com.group_3.backen_project.models;

import jakarta.persistence.*;

@Entity
public class Descriptions_bootcamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
