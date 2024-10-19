package com.group_3.backen_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users implements com.group_3.backen_project.models.interfaces.Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_birth", nullable = true)
    private String dateBirth;

    private String email;
    private String password;
    private String rol;

}