package com.pajehyk.scheduler.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_list")
public class TaskList {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long numberOfTasks;
    private Long userId;

    protected TaskList() {}

    public TaskList(String name, String description, Long numberOfTasks, Long userId) {
        this.name = name;
        this.description = description;
        this.numberOfTasks = numberOfTasks;
        this.userId = userId;
    }

    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public Long getNumberOfTasks() {
        return this.numberOfTasks;
    }
    public Long getUserId() {
        return this.userId;
    }
}
