package com.example.medicare.MedicareApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class LabTest
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotBlank(message = "Name Field Should not be Blank")
    private String name;
    @Positive(message = "Price Should not be in Negative")
    private double price;
    @NotBlank(message = "Description Field Should not be Blank")
    private String description;
    @NotBlank(message = "Category Field Should not be Blank")
    private String category;

}
