package com.example.medicare.MedicareApp.controllers;

import com.example.medicare.MedicareApp.entities.Order;
import com.example.medicare.MedicareApp.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeorder")
    public ResponseEntity<?> placeOrder(@Valid @RequestBody Order order)
   {
       return  new ResponseEntity<>(orderService.placeOrder(order), HttpStatus.CREATED);
   }
  @GetMapping ("/getOrder/{id}")
  public ResponseEntity<?> getOrderById(@PathVariable Long id)
  {
      return  new ResponseEntity<>(orderService.getOrderById(id),HttpStatus.FOUND);
  }
   @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrders()
   {
       return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
   }

   @DeleteMapping("/cancelorde/{id}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long id)
   {
       return  new ResponseEntity<>(orderService.cancelOrder(id),HttpStatus.OK);
   }
}
