package com.test.disrupting.vet.service.impl;

import com.test.disrupting.vet.dto.request.DoctorRequest;
import com.test.disrupting.vet.dto.response.DoctorResponse;
import com.test.disrupting.vet.entity.Appointment;
import com.test.disrupting.vet.entity.Doctor;
import com.test.disrupting.vet.repository.AppointmentRepository;
import com.test.disrupting.vet.repository.DoctorRepository;
import com.test.disrupting.vet.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    /**
     * Metodo para la creación de un medico, se puede mejorar con manejo de excepciones o errores de negocio
     * con RestExceptionHandler
     *
     * @param request           Request medico.
     */
    @Override
    public void createDoctor(final DoctorRequest request) {
        Doctor doctor = new Doctor();

        doctor.setName(request.getName());
        doctor.setLastName(request.getLastName());
        doctor.setSecondLastName(request.getSecondLastName());
        doctor.setProfessionalId(request.getProfessionalId());

        doctorRepository.save(doctor);
    }

    /**
     * Metodo para la actualización de un medico, se puede mejorar con manejo de excepciones o errores de negocio
     * con RestExceptionHandler
     *
     * @param request           Request medico.
     */
    @Override
    public void updateDoctor(final DoctorRequest request) {
        Doctor doctor = new Doctor();

        doctor.setId(request.getId());
        doctor.setName(request.getName());
        doctor.setLastName(request.getLastName());
        doctor.setSecondLastName(request.getSecondLastName());
        doctor.setProfessionalId(request.getProfessionalId());

        doctorRepository.save(doctor);
    }

    /**
     * Metodo para la eliminación de un medico, se puede mejorar con manejo de excepciones o errores de negocio
     * con RestExceptionHandler
     *
     * @param doctorId           Id medico.
     */
    @Override
    public void deleteDoctor(final Integer doctorId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);

        doctorOptional.ifPresent(doctor -> {
            List<Appointment> appointments = appointmentRepository.findByDoctorId(doctor.getId());

            appointmentRepository.deleteAll(appointments);

            doctorRepository.delete(doctor);
        });
    }

    /**
     * Metodo para la consulta de un medico, se puede mejorar con manejo de excepciones o errores de negocio
     * con RestExceptionHandler
     *
     * @param doctorId           Id medico.
     */
    @Override
    public DoctorResponse getDoctor(final Integer doctorId) {
        DoctorResponse response = new DoctorResponse();

        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);

        doctorOptional.ifPresent(doctor -> {
            response.setId(doctor.getId());
            response.setName(doctor.getName());
            response.setProfessionalId(doctor.getProfessionalId());
            response.setLastName(doctor.getLastName());
            response.setSecondLastName(doctor.getSecondLastName());
        });

        return response;
    }
}
