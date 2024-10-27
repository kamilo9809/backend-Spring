package com.group_3.backen_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Status_institutions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_review")
    private String statusReview;
}
