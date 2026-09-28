package com.example.medicare.MedicareApp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CartItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private  Long id;
    private  Long userid;
    private Long medicineid;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="med_id")
    private  Medicine medicine;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;


}
