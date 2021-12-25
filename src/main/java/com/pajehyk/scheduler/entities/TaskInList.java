package com.pajehyk.scheduler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_in_list")
public class TaskInList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_id")
    private Long taskId;
    @Column(name = "list_id")
    private Long listId;

    protected TaskInList() {}

    public TaskInList(Long taskId, Long listId) {
        this.taskId = taskId;
        this.listId = listId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Long getListId() {
        return listId;
    }
}
