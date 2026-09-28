package com.example.medicare.MedicareApp.controllers;

import com.example.medicare.MedicareApp.entities.LabTest;
import com.example.medicare.MedicareApp.entities.Medicine;

import com.example.medicare.MedicareApp.services.MedicineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController
{
    @Autowired
    private MedicineService medicineService;
    @PostMapping("/addMedicine")
    public ResponseEntity<?> addMedicine(@Valid  @RequestBody Medicine medicine)
    {
        return  new ResponseEntity<>(medicineService.addMedicine(medicine), HttpStatus.CREATED);
    }
    @GetMapping("/getAllMedicine")
    public ResponseEntity<?> getAllMedicine()
    {
        return new ResponseEntity<>(medicineService.getAllMedicines(),HttpStatus.OK);
    }
    @PutMapping("updateMedicine/{id}")
     public ResponseEntity<?> updateMedicine(@PathVariable Long id,@RequestBody Medicine medicine)
    {
        return  new ResponseEntity<>(medicineService.updateMedicine(id,medicine),HttpStatus.OK);
    }

 @GetMapping("/filter")
    public ResponseEntity<?> filter (@RequestParam String category)
 {
     return new ResponseEntity<>(medicineService.getMedicineByCategory(category),
             HttpStatus.FOUND);
 }
}
