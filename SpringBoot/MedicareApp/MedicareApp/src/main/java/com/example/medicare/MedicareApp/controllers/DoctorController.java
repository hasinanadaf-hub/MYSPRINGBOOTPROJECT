package com.example.medicare.MedicareApp.controllers;

import com.example.medicare.MedicareApp.entities.Doctor;
import com.example.medicare.MedicareApp.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    // Save Doctor
    @PostMapping("/savedoctor")
    public ResponseEntity<?> saveDoctor(
            @Valid @RequestBody Doctor doctor) {

        return new ResponseEntity<>(
                doctorService.saveDoctor(doctor),
                HttpStatus.CREATED
        );
    }


    // Get All Doctors
    @GetMapping("/getAlldoctors")
    public ResponseEntity<?> getAllDoctors() {

        return new ResponseEntity<>(
                doctorService.getAllDoctors(),
                HttpStatus.OK
        );
    }


    // Get Doctor By ID
    @GetMapping("/getDoctorById/{id}")
    public ResponseEntity<?> getDoctorById(
            @PathVariable Long id) {

        return new ResponseEntity<>(
                doctorService.getDoctorById(id),
                HttpStatus.OK
        );
    }


    // Get Doctor By Specialization
    @GetMapping("/getDoctorBySpec/{spec}")
    public ResponseEntity<?> getDoctorBySpec(
            @PathVariable String spec) {

        return new ResponseEntity<>(
                doctorService.getDoctorBySpecialization(spec),
                HttpStatus.OK
        );
    }


    // Delete Doctor
    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity<?> deleteDoctorById(
            @PathVariable Long id) {

        return new ResponseEntity<>(
                doctorService.deleteDoctor(id),
                HttpStatus.OK
        );
    }


    // Update Doctor
    @PutMapping("/updateDoctor/{id}")
    public ResponseEntity<?> updateDoctorById(
            @RequestBody Doctor doctor,
            @PathVariable Long id) {

        return new ResponseEntity<>(
                doctorService.updateDoctor(doctor, id),
                HttpStatus.OK
        );
    }
}