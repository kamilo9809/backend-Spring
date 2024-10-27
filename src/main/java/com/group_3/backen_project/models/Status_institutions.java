package com.group_3.backen_project.models;

import jakarta.persistence.*;

@Entity
public class Status_institutions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_review")
    private String statusReview;
}
