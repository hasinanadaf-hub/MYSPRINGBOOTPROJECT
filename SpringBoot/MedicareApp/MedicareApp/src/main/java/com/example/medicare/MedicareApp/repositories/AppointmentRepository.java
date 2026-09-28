package com.example.medicare.MedicareApp.repositories;

import com.example.medicare.MedicareApp.entities.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointments,Long>
{

}
