package com.lothin.phoneshp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothin.phoneshp.model.ProductImportHistory;

public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistory, Long> {

}
