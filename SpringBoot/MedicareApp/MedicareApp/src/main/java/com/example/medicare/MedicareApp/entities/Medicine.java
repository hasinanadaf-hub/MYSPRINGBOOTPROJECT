package com.example.medicare.MedicareApp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Medicine
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotBlank(message="Name Field is Required Data")
    private String name;
    @NotBlank(message="Category Field is Required Data")
    private String category;
    @Positive(message="Price Values below 0 not allowed")
    private double price;
    @NotBlank(message="Description Field is Required Data")
    private String description;
    @NotBlank(message="Image Field is Required Data")
    private String image;
    @OneToMany(mappedBy = "medicine")
    private List<CartItem> cartItems;


}
