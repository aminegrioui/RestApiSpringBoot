package com.example.com.java.trainee.repository;

import com.example.com.java.trainee.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
