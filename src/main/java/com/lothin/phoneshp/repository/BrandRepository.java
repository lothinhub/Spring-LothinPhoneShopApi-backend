package com.lothin.phoneshp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothin.phoneshp.model.Brand;
public interface BrandRepository extends JpaRepository<Brand,Integer>{
    
}
