package com.test.disrupting.vet.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vet_paciente")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "id_tipo_paciente", nullable = false)
    private String typePatientId;

    @Column(name = "fecha_nacimiento")
    private Date birthDay;

    @Column(name = "id_propietario", nullable = false)
    private Integer ownerId;

}
