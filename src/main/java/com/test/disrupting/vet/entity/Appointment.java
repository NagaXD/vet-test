package com.test.disrupting.vet.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "vet_cita")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita", nullable = false)
    private Integer id;

    @Column(name = "id_paciente", nullable = false)
    private Integer patientId;

    @Column(name = "id_medico")
    private Integer doctorId;

    @Column(name = "fecha")
    private Timestamp date;
}
