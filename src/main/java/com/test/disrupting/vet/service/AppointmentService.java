package com.test.disrupting.vet.service;

import com.test.disrupting.vet.dto.request.AppointmentRequest;
import com.test.disrupting.vet.dto.response.AppointmentResponse;

public interface AppointmentService {

    void createAppointment(AppointmentRequest request);

    void updateAppointment(AppointmentRequest request);

    void deleteAppointment(Integer appointmentId);

    AppointmentResponse getAppointment(Integer appointmentId);

}
