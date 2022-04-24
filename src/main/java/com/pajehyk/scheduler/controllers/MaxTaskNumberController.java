package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.entities.MaxTaskNumber;
import com.pajehyk.scheduler.repositories.MaxTaskNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/number")
public class MaxTaskNumberController {
    @Autowired
    private MaxTaskNumberRepository maxTaskNumberRepository;

    @GetMapping("/get/{userId}")
    public long get(@PathVariable Long userId) {
        long num = maxTaskNumberRepository.getById(userId).getMaxValue();
        return num;
    }

    @PostMapping("/add")
    public void add(@RequestBody MaxTaskNumber maxTaskNumber) {
        maxTaskNumberRepository.save(maxTaskNumber);
    }

    @GetMapping("/incr/{userId}")
    public void increment(@PathVariable Long userId) {
        maxTaskNumberRepository.increment(userId);
    }

    @GetMapping("/decr/{userId}")
    public void decrement(@PathVariable Long userId) {
        maxTaskNumberRepository.decrement(userId);
    }
}
