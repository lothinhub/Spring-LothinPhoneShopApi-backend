package com.lothin.phoneshp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.lothin.phoneshp.dto.ProductDTO;
import com.lothin.phoneshp.dto.ProductDTO2;

import com.lothin.phoneshp.model.Product;
import com.lothin.phoneshp.service.ColorService;
import com.lothin.phoneshp.service.ModelService;

@Mapper(componentModel = "spring", uses = { ModelService.class, ColorService.class })
public interface ProductMapper {
    @Mapping(target = "model", source = "dto.modelId")
    @Mapping(target = "color", source = "dto.colorId")
    Product toProduct(ProductDTO dto);

    @Mapping(target = "modelId", source = "model.id")
    @Mapping(target = "colorId", source = "color.id")
    ProductDTO2 toDTO(Product entity);
}
