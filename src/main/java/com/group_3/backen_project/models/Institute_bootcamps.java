package com.group_3.backen_project.models;

import jakarta.persistence.*;

@Entity
public class Institute_bootcamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_institutions", referencedColumnName = "id")
    private Institutions institutions;

    @OneToMany
    @JoinColumn(name = "id_bootcamps", referencedColumnName = "id")
    private Bootcamps bootcamps; 
}
