package com.pajehyk.scheduler.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "user_id")
    private Long userId;
    private String description;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "completion_date")
    private Date completionDate;

    protected Task() {}

    public Task(String taskName, Long userId, String description, Date creationDate, Date completionDate) {
        this.taskName = taskName;
        this.userId = userId;
        this.description = description;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public Long getUserId() {
        return this.userId;
    }
    public String getDescription() {
        return this.description;
    }
    public Date getCreationDate() {
        return this.creationDate;
    }
    public Date getCompletionDate() {
        return this.completionDate;
    }
}
