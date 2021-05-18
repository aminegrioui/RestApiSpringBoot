package com.example.com.java.trainee.repository;

import com.example.com.java.trainee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}