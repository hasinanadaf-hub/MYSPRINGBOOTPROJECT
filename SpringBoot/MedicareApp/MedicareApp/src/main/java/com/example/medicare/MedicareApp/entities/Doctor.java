package com.example.medicare.MedicareApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doc_id")
    private  Long id;
    @NotBlank(message = "Name is Required")
    private String name;
    @NotBlank(message = "Specialization is Required")
    private String specialization;
    @Min(value = 1,message="Experience must be atleat 1 Year")
    private Integer experience;
    @Positive(message ="Fees should be positive")
    private Double fees;
    @NotBlank(message ="Descriotion Should not be blank")
    private String description;
    private String image;
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Appointments> appointments;

}
