package com.lothin.phoneshp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothin.phoneshp.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
