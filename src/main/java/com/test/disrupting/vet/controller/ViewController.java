package com.test.disrupting.vet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    /**
     * View detalle doctor.
     *
     * @return jsp
     */
    @GetMapping("/doctor-details")
    public String doctorDetails() {
        return "doctor-details";
    }

    /**
     * View crear doctor.
     *
     * @return jsp
     */
    @GetMapping("/create-doctor")
    public String createDoctor() {
        return "create-doctor";
    }

    /**
     * View editar doctor.
     *
     * @return jsp
     */
    @GetMapping("/edit-doctor")
    public String editDoctor() {
        return "edit-doctor";
    }

}
