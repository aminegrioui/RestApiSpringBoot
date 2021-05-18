package com.example.com.java.trainee.repository;

import com.example.com.java.trainee.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository  extends JpaRepository<Trainee,Long> {
}
