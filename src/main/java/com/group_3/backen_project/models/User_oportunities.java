package com.group_3.backen_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User_oportunities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Users users;

    @OneToMany
    @JoinColumn(name = "id_opportunity", referencedColumnName = "id")
    private Opportunities opportunities;
}
