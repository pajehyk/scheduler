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

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Task objTask = (Task) obj;
        if (!this.getId().equals(objTask.getId())) {
            return false;
        }
        if (!this.getTaskName().equals(objTask.getTaskName())) {
            return false;
        }
        if (!this.getUserId().equals(objTask.getUserId())) {
            return false;
        }
        if (!this.getDescription().equals(objTask.getDescription())) {
            return false;
        }
        if (!this.getCreationDate().equals(objTask.getCreationDate())) {
            return false;
        }
        if (!this.getCompletionDate().equals(objTask.getCompletionDate())) {
            return false;
        }
        return true;
    }
}
