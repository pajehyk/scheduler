package com.pajehyk.scheduler.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_user")
public class MyUser {
    @Id 
    private Long id;
    private String name;

    protected MyUser() {}

    public MyUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
