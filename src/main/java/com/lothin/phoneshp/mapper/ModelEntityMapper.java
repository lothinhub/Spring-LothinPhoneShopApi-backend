package com.lothin.phoneshp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lothin.phoneshp.dto.ModelDTO;
// import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.model.Model;
import com.lothin.phoneshp.service.BrandService;

@Mapper(componentModel = "spring", uses = { BrandService.class })
public interface ModelEntityMapper {
    ModelEntityMapper INSTANCE = Mappers.getMapper(ModelEntityMapper.class);

    @Mapping(target = "brand", source = "dto.brandId")
    Model toModel(ModelDTO dto);

    @Mapping(target = "brandId", source = "brand.id")
    ModelDTO toDTO(Model entity);
}
