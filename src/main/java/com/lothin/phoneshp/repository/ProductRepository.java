package com.lothin.phoneshp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothin.phoneshp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
