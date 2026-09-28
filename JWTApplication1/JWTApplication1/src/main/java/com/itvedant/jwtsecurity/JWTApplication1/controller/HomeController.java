package com.itvedant.jwtsecurity.JWTApplication1.controller;

import com.itvedant.jwtsecurity.JWTApplication1.entity.User;
import com.itvedant.jwtsecurity.JWTApplication1.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/jwt")
public class HomeController
{
   @Autowired
    private UserServices userServices;
    //http://localhost:8085/api/jwt/welcome

    @GetMapping("/welcome")
    public String Welcome()
    {
        return  "Welcome To JWT Web Development";
    }
    //http://localhost:8085/api/jwt/hello
    @GetMapping("/hello")
    public String Hello()
    {

     return "Hello To the World Of Security";
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers()
    {

     return userServices.getUsers();
    }
    @GetMapping("/whoamI")
 public String getUser(Principal principal)
    {
      return principal.getName();
    }
}
