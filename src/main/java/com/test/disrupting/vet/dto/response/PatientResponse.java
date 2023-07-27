package com.test.disrupting.vet.dto.response;

import com.test.disrupting.vet.dto.OwnerDto;
import lombok.Data;

import java.util.Date;

@Data
public class PatientResponse {

    private Integer id;

    private String name;

    private String patientTypeId;

    private Date birthDay;

    private OwnerDto owner;

}
