package com.example.medicare.MedicareApp.services;

import com.example.medicare.MedicareApp.entities.LabTest;
import com.example.medicare.MedicareApp.repositories.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabTestService
{
    @Autowired
    private LabTestRepository labTestRepository;

    public LabTest saveLabTest(LabTest labTest)
    {
        return  labTestRepository.save(labTest);
    }
}
