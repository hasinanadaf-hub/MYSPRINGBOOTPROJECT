package com.example.medicare.MedicareApp.repositories;

import com.example.medicare.MedicareApp.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long>
{
}
