package com.example.medicare.MedicareApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="appointments")
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "AppoinmentDate is Required")
    private String appointmentdate;
    private  String timeslot;
    @NotBlank(message = "Reason Should not Be Blank")
    private String reason;
    @NotBlank(message = "statuc Should not Be Blank")
    private String status;
    @NotBlank(message = "PaymentStatus Should not Be Blank")
    private String paymentstatus;
    private String paymentmode;
    private Double billamount;
    @ManyToOne
    @JoinColumn(name="pat_id")
   // @JsonBackReference(value = "user-appointments")
    @JsonIgnoreProperties("appointments")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doc_id")
    //@JsonBackReference(value = "doctor-appointments")
    @JsonIgnoreProperties("appointments")
    private Doctor doctor;


}

