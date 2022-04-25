package com.pajehyk.scheduler.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_tasks")
public class UserTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "task_id", insertable = false, updatable = false)
    private Long taskId;
    @Column(name = "task_num")
    private Long taskNum;

    @OneToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    protected UserTasks() {}

    public UserTasks(long userId) {
        this.userId = userId;
    }

    public UserTasks(Long id, Long userId, Long taskId, Long taskNum) {
        this.id = id;
        this.userId = userId;
        this.taskId = taskId;
        this.taskNum = taskNum;
    }

    public UserTasks(Long userId, Long taskId, Long taskNum) {
        this.userId = userId;
        this.taskId = taskId;
        this.taskNum = taskNum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setTaskNum(Long taskNum) {
        this.taskNum = taskNum;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Long getTaskNum() {
        return taskNum;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
