package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.TelegramUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {

}
