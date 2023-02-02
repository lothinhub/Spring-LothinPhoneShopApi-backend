package com.lothin.phoneshp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lothin.phoneshp.dto.ImportDTO;
import com.lothin.phoneshp.model.Product;
import com.lothin.phoneshp.model.ProductImportHistory;

@Mapper
public interface ProductImportHistoryMapper {
	ProductImportHistoryMapper INSTANCE = Mappers.getMapper(ProductImportHistoryMapper.class);

	@Mapping(target = "product", source = "product")
	@Mapping(target = "id", ignore = true)
	ProductImportHistory toEntity(ImportDTO importDTO, Product product);
}
