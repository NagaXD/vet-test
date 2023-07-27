package com.test.disrupting.vet.dto.request;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AppointmentRequest {

    private Integer id;

    private Integer patientId;

    private Integer doctorId;

    private Timestamp date;

}

