package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.MyUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    
}
