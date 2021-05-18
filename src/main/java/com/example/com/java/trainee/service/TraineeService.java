package com.example.com.java.trainee.service;

import com.example.com.java.trainee.entity.Product;
import com.example.com.java.trainee.entity.Trainee;
import com.example.com.java.trainee.repository.ProductRepository;
import com.example.com.java.trainee.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TraineeService {
    @Autowired
    private TraineeRepository repo;

    public List<Trainee> listAll() {
        return repo.findAll();
    }

    public void save(Trainee trainee) {
        repo.save(trainee);
    }

    public Trainee get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
