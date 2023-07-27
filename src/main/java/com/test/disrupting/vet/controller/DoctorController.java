package com.test.disrupting.vet.controller;

import com.test.disrupting.vet.dto.request.DoctorRequest;
import com.test.disrupting.vet.dto.response.DoctorResponse;
import com.test.disrupting.vet.service.DoctorService;
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
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     * EndPoint para la alta de un medico.
     *
     * @param request       Datos del medico.
     * @return created 201.
     */
    @PostMapping("/doctor")
    private ResponseEntity<Void> createDoctor(@RequestBody final DoctorRequest request) {
        doctorService.createDoctor(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * EndPoint para la actualización de un medico.
     *
     * @param request       Datos del medico.
     * @return noContent 204.
     */
    @PutMapping("/doctor")
    private ResponseEntity<Void> updateDoctor(@RequestBody final DoctorRequest request) {
        doctorService.updateDoctor(request);
        return ResponseEntity.noContent().build();
    }

    /**
     * EndPoint para la eliminación de un medico por id medico.
     *
     * @param doctorId       Id medico.
     * @return noContent 204.
     */
    @DeleteMapping("/doctor/{doctorId}")
    private ResponseEntity<Void> deleteDoctor(@PathVariable final Integer doctorId) {
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.noContent().build();
    }

    /**
     * EndPoint para la obtención de un medico por id medico.
     *
     * @param doctorId       Id medico.
     * @return medico.
     */
    @GetMapping("/doctor/{doctorId}")
    private ResponseEntity<DoctorResponse> getDoctor(@PathVariable final Integer doctorId) {
        return new ResponseEntity<>(doctorService.getDoctor(doctorId), HttpStatus.OK);
    }

}
