package com.example.medicare.MedicareApp.services;

import com.example.medicare.MedicareApp.entities.Order;
import com.example.medicare.MedicareApp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order)
    {
        if(order.getStatus()== null)
        {
            order.setStatus("Placed");
        }
        return orderRepository.save(order);
    }
    public Order getOrderById(Long id)
    {
        return  orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public Boolean cancelOrder(Long id)
    {
         orderRepository.deleteById(id);
         return true;
    }
}
