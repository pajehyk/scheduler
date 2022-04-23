package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.MaxTaskNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaxTaskNumberRepository extends JpaRepository<MaxTaskNumber, Long> {
}
