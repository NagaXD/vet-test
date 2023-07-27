package com.test.disrupting.vet.service;

import com.test.disrupting.vet.dto.request.PatientRequest;
import com.test.disrupting.vet.dto.response.PatientResponse;

public interface PatientService {

    void createPatient(PatientRequest request);

    void updatePatient(PatientRequest request);

    void deletePatient(Integer patientId);

    PatientResponse getPatient(Integer patientId);

}
