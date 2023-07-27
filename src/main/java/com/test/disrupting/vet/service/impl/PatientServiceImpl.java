package com.test.disrupting.vet.service.impl;

import com.test.disrupting.vet.dto.OwnerDto;
import com.test.disrupting.vet.dto.request.PatientRequest;
import com.test.disrupting.vet.dto.response.PatientResponse;
import com.test.disrupting.vet.entity.Appointment;
import com.test.disrupting.vet.entity.Owner;
import com.test.disrupting.vet.entity.Patient;
import com.test.disrupting.vet.repository.AppointmentRepository;
import com.test.disrupting.vet.repository.OwnerRepository;
import com.test.disrupting.vet.repository.PatientRepository;
import com.test.disrupting.vet.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    /**
     * Metodo para la creacion de un paciente y su propietario, se puede mejorar con manejo de excepciones usando
     * RestExceptionHandler.
     *
     * @param request               Request paciente.
     */
    @Override
    public void createPatient(final PatientRequest request) {
        Owner owner = new Owner();

        owner.setName(request.getOwner().getName());
        owner.setPhone(request.getOwner().getPhone());
        owner.setLastName(request.getOwner().getLastName());
        owner.setSecondLastName(request.getOwner().getSecondLastName());

        owner = ownerRepository.save(owner);

        Patient patient = new Patient();

        patient.setTypePatientId(request.getPatientTypeId());
        patient.setBirthDay(request.getBirthDay());
        patient.setName(request.getName());
        patient.setOwnerId(owner.getId());

        patientRepository.save(patient);
    }

    /**
     * Metodo para la actualización de un paciente y su propietario, se puede mejorar con manejo de excepciones usando
     * RestExceptionHandler.
     *
     * @param request               Request paciente.
     */
    @Override
    public void updatePatient(final PatientRequest request) {
        Owner owner = new Owner();

        owner.setId(request.getOwner().getId());
        owner.setName(request.getOwner().getName());
        owner.setPhone(request.getOwner().getPhone());
        owner.setLastName(request.getOwner().getLastName());
        owner.setSecondLastName(request.getOwner().getSecondLastName());

        owner = ownerRepository.save(owner);

        Patient patient = new Patient();

        patient.setId(request.getId());
        patient.setTypePatientId(request.getPatientTypeId());
        patient.setBirthDay(request.getBirthDay());
        patient.setName(request.getName());
        patient.setOwnerId(owner.getId());

        patientRepository.save(patient);
    }

    /**
     * Metodo para la eliminación de un paciente y su propietario, se puede mejorar con manejo de excepciones usando
     * RestExceptionHandler.
     *
     * @param patientId               Id paciente.
     */
    @Override
    public void deletePatient(final Integer patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        optionalPatient.ifPresent(patient -> {
            List<Appointment> appointments = appointmentRepository.findByPatientId(patient.getId());

            appointmentRepository.deleteAll(appointments);

            patientRepository.delete(patient);

            Optional<Owner> optionalOwner = ownerRepository.findById(patient.getOwnerId());

            optionalOwner.ifPresent(owner -> {
                ownerRepository.delete(owner);
            });
        });
    }

    /**
     * Metodo para la consulta de un paciente y su propietario, se puede mejorar con manejo de excepciones usando
     * RestExceptionHandler.
     *
     * @param patientId               Id paciente.
     */
    @Override
    public PatientResponse getPatient(final Integer patientId) {
        PatientResponse response = new PatientResponse();

        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        optionalPatient.ifPresent(patient -> {
            Optional<Owner> optionalOwner = ownerRepository.findById(patient.getOwnerId());

            optionalOwner.ifPresent(owner -> {
                OwnerDto ownerDto = new OwnerDto();

                ownerDto.setId(owner.getId());
                ownerDto.setName(owner.getName());
                ownerDto.setPhone(owner.getPhone());
                ownerDto.setLastName(owner.getLastName());
                ownerDto.setSecondLastName(owner.getSecondLastName());

                response.setOwner(ownerDto);
            });

            response.setId(patient.getId());
            response.setName(patient.getName());
            response.setBirthDay(patient.getBirthDay());
            response.setPatientTypeId(patient.getTypePatientId());
        });

        return response;
    }
}
