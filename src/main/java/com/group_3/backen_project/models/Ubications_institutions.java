package com.group_3.backen_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ubications_institutions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 144)
    private String zona;
}
