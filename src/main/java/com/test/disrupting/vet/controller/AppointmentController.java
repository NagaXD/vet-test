package com.test.disrupting.vet.controller;

import com.test.disrupting.vet.dto.request.AppointmentRequest;
import com.test.disrupting.vet.dto.response.AppointmentResponse;
import com.test.disrupting.vet.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller para citas.
 *
 * @author jairnagano
 */
@RequestMapping("/api/v1")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    /**
     * EndPoint para crear una cita entre un paciente y un doctor.
     *
     * @param request           Request con los datos de la cita.
     * @return  created 201.
     */
    @PostMapping("/appointment")
    private ResponseEntity<Void> createAppointment(@RequestBody final AppointmentRequest request) {
        appointmentService.createAppointment(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * EndPoint para actualizar una cita entre un paciente y un doctor.
     *
     * @param request           Request con los datos de la cita.
     * @return  noContent 204.
     */
    @PutMapping("/appointment")
    private ResponseEntity<Void> updateAppointment(@RequestBody final AppointmentRequest request) {
        appointmentService.updateAppointment(request);
        return ResponseEntity.noContent().build();
    }

    /**
     * EndPoint para eliminar una cita entre un paciente y un doctor por id de la cita.
     *
     * @param appointmentId           Id de la cita.
     * @return  noContent 204.
     */
    @DeleteMapping("/appointment/{appointmentId}")
    private ResponseEntity<Void> deleteAppointment(@PathVariable final Integer appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }

    /**
     * EndPoint para consultar una cita entre un paciente y un doctor por id de cita.
     *
     * @param appointmentId           Id de la cita.
     * @return  cita.
     */
    @GetMapping("/appointment/{appointmentId}")
    private ResponseEntity<AppointmentResponse> getAppointment(@PathVariable final Integer appointmentId) {
        return new ResponseEntity<>(appointmentService.getAppointment(appointmentId), HttpStatus.OK);
    }
}
