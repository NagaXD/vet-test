package com.test.disrupting.vet.dto.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AppointmentResponse {

    private Integer id;

    private Integer patientId;

    private Integer doctorId;

    private Timestamp date;

}
