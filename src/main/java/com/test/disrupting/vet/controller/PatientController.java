package com.test.disrupting.vet.controller;

import com.test.disrupting.vet.dto.request.PatientRequest;
import com.test.disrupting.vet.dto.response.PatientResponse;
import com.test.disrupting.vet.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller para medicos.
 *
 * @author jairnagano
 */
@RequestMapping("/api/v1")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * EndPoint para el alta de un paciente y su propiertario.
     *
     * @param request           Datos del paciente y propietario.
     * @return created 201.
     */
    @PostMapping("/patient")
    private ResponseEntity<Void> createPatient(@RequestBody final PatientRequest request) {
        patientService.createPatient(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * EndPoint para la actualización de un paciente y su propiertario.
     *
     * @param request           Datos del paciente y propietario.
     * @return noContend 204.
     */
    @PutMapping("/patient")
    private ResponseEntity<Void> updatePatient(@RequestBody final PatientRequest request) {
        patientService.updatePatient(request);
        return ResponseEntity.noContent().build();
    }

    /**
     * EndPoint para la eliminación de un paciente y su propiertario por id de paciente.
     *
     * @param patientId           Id de paciente.
     * @return noContend 204.
     */
    @DeleteMapping("/patient/{patientId}")
    private ResponseEntity<Void> deletePatient(@PathVariable final Integer patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.noContent().build();
    }

    /**
     * EndPoint para la consulta de un paciente y su propiertario por id de paciente.
     *
     * @param patientId           Id de paciente.
     * @return paciente y propietario.
     */
    @GetMapping("/patient/{patientId}")
    private ResponseEntity<PatientResponse> getPatient(@PathVariable final Integer patientId) {
        return new ResponseEntity<>(patientService.getPatient(patientId), HttpStatus.OK);
    }

}
