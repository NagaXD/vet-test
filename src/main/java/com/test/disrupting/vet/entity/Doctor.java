package com.test.disrupting.vet.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "vet_medico")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "apellido_paterno", nullable = false)
    private String lastName;

    @Column(name = "apellido_materno", nullable = false)
    private String secondLastName;

    @Column(name = "cedula", nullable = false)
    private String professionalId;


}
