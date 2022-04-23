package com.pajehyk.scheduler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "max_task_number")
public class MaxTaskNumber {
    @Id
    private long userId;
    @Column(name = "max_value")
    private int maxValue;

    protected MaxTaskNumber() {}

    public MaxTaskNumber(long userId) {
        this.userId = userId;
        this.maxValue = 1;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public long getUserId() {
        return userId;
    }
}
