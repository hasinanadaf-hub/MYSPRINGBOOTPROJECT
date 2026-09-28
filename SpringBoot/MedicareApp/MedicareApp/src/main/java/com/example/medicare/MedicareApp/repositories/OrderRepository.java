package com.example.medicare.MedicareApp.repositories;

import com.example.medicare.MedicareApp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>
{
}
