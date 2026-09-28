package com.example.medicare.MedicareApp.repositories;

import com.example.medicare.MedicareApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{
}
