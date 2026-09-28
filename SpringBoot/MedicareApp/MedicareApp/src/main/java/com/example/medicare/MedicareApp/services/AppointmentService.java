package com.example.medicare.MedicareApp.services;

import com.example.medicare.MedicareApp.entities.Appointments;
import com.example.medicare.MedicareApp.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService
{
    @Autowired
    private AppointmentRepository appointmentRepository;
    public Appointments addAppointment(Appointments appointments)

    {
        appointments.setStatus("Pending");
        return  appointmentRepository.save(appointments);
    }

    public List<Appointments> getAllAppointments()

    {
        return appointmentRepository.findAll();
    }


    public Appointments confirmAppointment(Long id)
    {
        Appointments appointments= appointmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Appointment not Booked"));
        appointments.setStatus("Booked");
        return appointmentRepository.save(appointments);
    }
    public Appointments processPayment(Long id,Double payamount ,String paymode)
    {
        Appointments appointment = appointmentRepository.findById(id).orElseThrow(
                ()->  new RuntimeException("Appointment Not Found"));
        appointment.setBillamount(payamount);
        appointment.setPaymentmode(paymode);
        appointment.setStatus("Booked");
        appointment.setPaymentstatus("Paid");
        return appointmentRepository.save(appointment);
    }
}
