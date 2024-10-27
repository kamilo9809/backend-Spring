package com.group_3.backen_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Institutions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    private Status_institutions idStatus;

    @OneToOne
    @JoinColumn(name = "ubications_institutions", referencedColumnName = "id")
    private Ubications_institutions ubicationsInstitutions;

    private String directions;

    @Column(name = "general_link")
    private String generalLink;

    @Column(name = "carer_link")
    private String carerLink;

    @Column(name = "bienestar_link")
    private String bienestarLink;

    @Column(name = "procces_link")
    private String proccesLink;
}