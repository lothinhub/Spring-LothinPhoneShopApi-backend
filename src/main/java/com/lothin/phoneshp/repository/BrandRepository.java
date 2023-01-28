package com.lothin.phoneshp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothin.phoneshp.model.Brand;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    boolean existsByName(String name);

    List<Brand> findByIdIn(List<Integer> ids);
}
