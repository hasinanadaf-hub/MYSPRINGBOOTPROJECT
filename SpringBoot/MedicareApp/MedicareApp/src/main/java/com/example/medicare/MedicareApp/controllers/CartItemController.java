package com.example.medicare.MedicareApp.controllers;

import com.example.medicare.MedicareApp.entities.CartItem;
import com.example.medicare.MedicareApp.services.CartItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CartItemController
{
    @Autowired
    private CartItemService cartItemService;
    @PostMapping("/addtocart")
    public ResponseEntity<?> saveCartItem(@Valid @RequestBody CartItem cartItem)
    {
        return  new ResponseEntity<>(cartItemService
                .addToCart(cartItem), HttpStatus.CREATED);
    }
    @GetMapping("/gatAllCartItems")
    public ResponseEntity<?> getAllCartItem()
    {
        return new ResponseEntity<>(cartItemService.getALl(),HttpStatus.OK);
    }
    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<?> deleteCartItemById(@PathVariable  Long id)
    {
        return new ResponseEntity<>(cartItemService.delete(id),HttpStatus.OK);
    }
    @PutMapping("/updatequantity/{id}")
    public ResponseEntity<?> updateQuantity(@PathVariable Long id,@RequestParam int quantity)
    {
        return new ResponseEntity<>(cartItemService.updateQuantity(id, quantity),HttpStatus.OK);
    }
}
