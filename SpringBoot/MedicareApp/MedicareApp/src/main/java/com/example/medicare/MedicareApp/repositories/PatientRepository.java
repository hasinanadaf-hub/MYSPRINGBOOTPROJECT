package com.example.medicare.MedicareApp.repositories;

import com.example.medicare.MedicareApp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>
{
List<Patient> findByBloodgroup(String bloodgroup);
}
