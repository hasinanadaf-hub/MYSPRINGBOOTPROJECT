package com.example.medicare.MedicareApp.controllers;

import com.example.medicare.MedicareApp.entities.Appointments;
import com.example.medicare.MedicareApp.services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController
{
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/addappointment")
    public ResponseEntity<?> addAppointment(@Valid @RequestBody Appointments appointment)
    {
        return  new ResponseEntity<>(appointmentService.addAppointment(appointment),
                HttpStatus.CREATED);
    }

    @GetMapping("/getappointments")
    public ResponseEntity<?> getAllAppointments()
    {
        return new ResponseEntity<>(appointmentService.getAllAppointments(),
                HttpStatus.OK);
    }

    @PutMapping("/confirm/{id}")
    public ResponseEntity<?> confirmAppoinment(@PathVariable Long id)
    {
        return  new ResponseEntity<>(appointmentService.confirmAppointment(id),
                HttpStatus.FOUND);
    }
    @PutMapping("/processpay/{id}")
    public ResponseEntity<?> processPayment(@PathVariable Long id,
                                                @RequestParam Double payment,
                                            @RequestParam String paymoode)
    {
        return  new ResponseEntity<>(appointmentService.processPayment(id,
                payment,paymoode),HttpStatus.OK);
    }

}
