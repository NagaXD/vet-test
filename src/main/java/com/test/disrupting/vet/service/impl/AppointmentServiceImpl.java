package com.test.disrupting.vet.service.impl;

import com.test.disrupting.vet.dto.request.AppointmentRequest;
import com.test.disrupting.vet.dto.response.AppointmentResponse;
import com.test.disrupting.vet.entity.Appointment;
import com.test.disrupting.vet.repository.AppointmentRepository;
import com.test.disrupting.vet.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    /**
     * Metodo para la creacion de una cita, se puede mejorar con manejo de excepciones (RestExceptionHandler).
     *
     * @param request           Request cita.
     */
    @Override
    public void createAppointment(final AppointmentRequest request) {
        Appointment appointment = new Appointment();

        appointment.setDate(request.getDate());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setPatientId(request.getPatientId());

        appointmentRepository.save(appointment);
    }

    /**
     * Metodo para la actualización de una cita, se puede mejorar con manejo de excepciones (RestExceptionHandler).
     *
     * @param request           Request cita.
     */
    @Override
    public void updateAppointment(final AppointmentRequest request) {
        Appointment appointment = new Appointment();

        appointment.setId(request.getId());
        appointment.setDate(request.getDate());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setPatientId(request.getPatientId());

        appointmentRepository.save(appointment);
    }

    /**
     * Metodo para la eliminación de una cita, se puede mejorar con manejo de excepciones (RestExceptionHandler).
     *
     * @param appointmentId           Id de la cita.
     */
    @Override
    public void deleteAppointment(final Integer appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);

        optionalAppointment.ifPresent(appointment -> appointmentRepository.delete(appointment));
    }

    /**
     * Metodo para la consulta de una cita, se puede mejorar con manejo de excepciones (RestExceptionHandler).
     *
     * @param appointmentId           Id de la cita.
     */
    @Override
    public AppointmentResponse getAppointment(final Integer appointmentId) {
        AppointmentResponse response = new AppointmentResponse();

        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);

        optionalAppointment.ifPresent(appointment -> {
            response.setDate(appointment.getDate());
            response.setId(appointment.getId());
            response.setDoctorId(appointment.getDoctorId());
            response.setPatientId(appointment.getPatientId());
        });

        return response;
    }
}
