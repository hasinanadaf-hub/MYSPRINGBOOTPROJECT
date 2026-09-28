package com.example.medicare.MedicareApp.controllers;

import com.example.medicare.MedicareApp.entities.User;
import com.example.medicare.MedicareApp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicare/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@Valid  @RequestBody User user)
    {
       return  new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers()
    {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);

    }
    @GetMapping("/getUserByRole/{role}")
    public ResponseEntity<?> getUserByRole(@PathVariable  String role)
    {
        return  new ResponseEntity<>(userService.getUserByRole(role),HttpStatus.FOUND);
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable Long id)
    {
        return  new ResponseEntity<>(userService.updateUser(user,id),HttpStatus.OK);
    }





}
