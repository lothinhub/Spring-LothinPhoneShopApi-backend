package com.lothin.phoneshp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import com.lothin.phoneshp.model.Brand;

import java.util.List;
// @Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    boolean existsByName(String name);

    List<Brand> findByIdIn(List<Long> ids);

    // List<Brand> findByActive(boolean active);
    List<Brand> findByActiveTrue();
}
