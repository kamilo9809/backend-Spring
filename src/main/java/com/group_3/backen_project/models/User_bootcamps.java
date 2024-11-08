package com.group_3.backen_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users bootcamps")
@Data
public class User_bootcamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Users idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_bootcamp", referencedColumnName = "id")
    private Bootcamps idBootcamp;
}
