package com.test.disrupting.vet.dto.request;

import lombok.Data;

@Data
public class DoctorRequest {

    private Integer id;

    private String name;

    private String lastName;

    private String secondLastName;

    private String professionalId;

}
