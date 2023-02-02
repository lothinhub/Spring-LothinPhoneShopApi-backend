package com.lothin.phoneshp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.lothin.phoneshp.dto.ProductDisplayDTO;
import com.lothin.phoneshp.dto.ProductImportDTO;
import com.lothin.phoneshp.model.Product;

public interface ProductService {
    Product save(ProductImportDTO productImportDTO);

	Product getById(Long id);

	Product setPrice(Long productId, BigDecimal price);

	Page<Product> getProducts(Map<String, String> params);

	List<ProductDisplayDTO> toProductDisplayDTOs(List<Product> products);

	boolean hasAvailableUnit(Long productId, Integer orderUnit);

	boolean salePriceIsSet(Long productId);
}
