package com.pajehyk.scheduler;

import java.util.List;

import com.pajehyk.scheduler.entities.MyUser;
import com.pajehyk.scheduler.repositories.MyUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheController {
    @Autowired
    MyUserRepository userRepository;

    @GetMapping("/start")
    public MyUser start(MyUser user) {
        userRepository.save(user);
        return user;
    }
    
    public List<MyUser> show() {
        return userRepository.findAll();
    }
}
