package com.example.medicare.MedicareApp.controllers;

import com.example.medicare.MedicareApp.entities.Doctor;
import com.example.medicare.MedicareApp.entities.LabTest;
import com.example.medicare.MedicareApp.services.DoctorService;
import com.example.medicare.MedicareApp.services.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
public class LabTestController
{
    @Autowired
    private LabTestService labTestService;
    @PostMapping("/savelabtest")
    public ResponseEntity<?> saveLabTest(@RequestBody LabTest labTest)
    {
        return  new ResponseEntity<>(labTestService.saveLabTest(labTest), HttpStatus.CREATED);
    }
}
