package com.lothin.phoneshp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lothin.phoneshp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> , JpaSpecificationExecutor<Product>  {

    Optional<Product> findByModelIdAndColorId(Long modelId, Long colorId);
}
