package com.example.medicare.MedicareApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Id Column should be reference type
    @NotBlank(message = "FirstName is Required Field")
    private String firstname;
    @NotBlank(message = "LastName is Required Field")
    private String lastname;
    private String gender;
    private LocalDate dateofbirth;
    @Size(max=10,message = "Phone No Should be 10 Digits ")
    private String phone;
    @Email(message = "InCorrect Format")
    private String email;
    @NotBlank(message = "Address is Required Field")
    private String address;
    @NotBlank(message = "BloodGroup is Required Field")
    private String bloodgroup;
    private LocalDateTime registrationdate;
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    @JsonManagedReference(value = "patient-appointments")
    private List<Appointments> appointments;


}
