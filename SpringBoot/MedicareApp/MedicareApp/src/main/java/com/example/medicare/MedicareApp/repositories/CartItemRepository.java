package com.example.medicare.MedicareApp.repositories;

import com.example.medicare.MedicareApp.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long>
{
}
