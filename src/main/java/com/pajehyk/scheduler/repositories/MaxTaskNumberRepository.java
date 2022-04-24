package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.MaxTaskNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MaxTaskNumberRepository extends JpaRepository<MaxTaskNumber, Long> {
    @Modifying
    @Transactional
    @Query("update MaxTaskNumber m set m.maxValue = m.maxValue + 1 where m.userId = :userId")
    void increment(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("update MaxTaskNumber m set m.maxValue = m.maxValue - 1 where m.userId = :userId")
    void decrement(@Param("userId") Long userId);
}
