package com.group_3.backen_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "bootcamps")
public class Bootcamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El idGeneral es obligatorio")
    @ManyToOne
    private Long idGeneral;

    @Column(nullable = true)
    @Size(max = 500, message = "La descripcion no puede exceder 500 caracteres")
    private String descripcion;

    @NotBlank(message = "El idTemas es obligatorio")
    @ManyToOne
    private Long idTemas;

    @NotBlank(message = "El nombre es obligatorio") //Valida que no esté vacío
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El idCostos es obligatorio")
    @ManyToOne
    private Long idCostos;

    @NotBlank(message = "El idEstado es obligatorio")
    @ManyToOne
    private Long idEstado;

    // Constructores
    public Bootcamps() {
    }

    public Bootcamps(Long idGeneral, String descripcion, Long idTemas, String nombre, Long idCostos, Long idEstado) {
        this.idGeneral = idGeneral;
        this.descripcion = descripcion;
        this.idTemas = idTemas;
        this.nombre = nombre;
        this.idCostos = idCostos;
        this.idEstado = idEstado;
    }

    // Getters y Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdGeneral() {
        return idGeneral;
    }

    public void setIdGeneral(Long idGeneral) {
        this.idGeneral = idGeneral;
    }

    public Long getIdTemas() {
        return idTemas;
    }

    public void setIdTemas(Long idTemas) {
        this.idTemas = idTemas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCostos() {
        return idCostos;
    }

    public void setIdCostos(Long idCostos) {
        this.idCostos = idCostos;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }
}
