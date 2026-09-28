package com.itvedant.jwtsecurity.JWTApplication1.services;

import com.itvedant.jwtsecurity.JWTApplication1.entity.User;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServices
{
    private List<User> userlist = new ArrayList<>();

public  UserServices()
{
    User u1 = new User(UUID.randomUUID().toString(),
            "Pratik","pratik@gmail.com");
    User u2 = new User(UUID.randomUUID().toString(),
            "Sayali","sayali@gmail.com");
    User u3 = new User(UUID.randomUUID().toString(),
            "Madhuri","madhuri@gmail.com");
    User u4 = new User(UUID.randomUUID().toString(),
            "Kanchan","kanchan@gmail.com");
    userlist.add(u1);
    userlist.add(u2);
    userlist.add(u3);
    userlist.add(u4);
    System.out.println(userlist);
}

public List<User> getUsers()
    {
        return this.userlist;
    }
}
