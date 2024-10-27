package com.group_3.backen_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "bootcamps")
@Data
public class Bootcamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El idGeneral es obligatorio")
    @ManyToOne
    private Descriptions_bootcamps idGeneral;

    @NotBlank(message = "El idTemas es obligatorio")
    @ManyToOne
    private Topics_bootcamps idTemas;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El idCostos es obligatorio")
    @ManyToOne
    private Costs_bootcamps idCostos;

    @NotBlank(message = "El idEstado es obligatorio")
    @ManyToOne
    private Status_bootcamps idEstado;
}
