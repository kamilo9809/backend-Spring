package com.group_3.backen_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Institute_opportunities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "id_institutions", referencedColumnName = "id")
    private Institutions institutions;

    @ManyToOne
    @JoinColumn(name = "id_opportunities", referencedColumnName = "id")
    private Opportunities opportunities;
}
