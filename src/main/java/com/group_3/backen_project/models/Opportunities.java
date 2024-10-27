package com.group_3.backen_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Opportunities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_categories", referencedColumnName = "id")
    private Categories_opportunities idCategories;

    @ManyToOne
    @JoinColumn(name = "id_status_review", referencedColumnName = "id")
    private Status_opportunities idStatus;

    @ManyToOne
    @JoinColumn(name = "oportunity_type", referencedColumnName = "id")
    private Type_opportunities typeOpportunities;

    private String observations;

    private String name;

    private String descriptions;

    @Column(length = 144)
    private String applications;

    private String requeriments; 
    
    private String guide; 

    @Column(name = "adicional_dates")
    private String adicionalDates; 
    
    @Column(name = "contact_channels")
    private String contactChannels; 
}
