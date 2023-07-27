package com.test.disrupting.vet.service;

import com.test.disrupting.vet.dto.request.DoctorRequest;
import com.test.disrupting.vet.dto.response.DoctorResponse;

public interface DoctorService {

    void createDoctor(DoctorRequest request);

    void updateDoctor(DoctorRequest request);

    void deleteDoctor(Integer doctorId);

    DoctorResponse getDoctor(Integer doctorId);

}
