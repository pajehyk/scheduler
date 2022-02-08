package com.pajehyk.scheduler.entities;

import com.pajehyk.scheduler.Status;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "telegram_user")
public class TelegramUser {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "telegram_id")
    private Long telegramId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String username;
    @Column(name = "registered_at")
    private Date date;
    @Enumerated(EnumType.STRING)
    private Status status;

    protected TelegramUser() {}

    public TelegramUser(Long telegramId, String firstName, String lastName, String username,
                        Date date, Status status) {
        this.telegramId = telegramId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public Long getTelegramId() {
        return this.telegramId;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getUsername() {
        return this.username;
    }
    public Date getDate() {
        return this.date;
    }
    public Status getStatus() {
        return this.status;
    }
}
