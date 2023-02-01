package com.lothin.phoneshp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lothin.phoneshp.dto.ProductDTO;
import com.lothin.phoneshp.model.Product;
import com.lothin.phoneshp.service.ModelService;

@Mapper(componentModel = "spring", uses = { ModelService.class })
public interface ProductMapper {
    @Mapping(target = "model", source = "dto.modelId")  
    Product toProduct(ProductDTO dto);

    @Mapping(target = "modelId", source = "model.id")
    ProductDTO toDTO(Product entity);
}
