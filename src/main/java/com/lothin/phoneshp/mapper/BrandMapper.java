package com.lothin.phoneshp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.lothin.phoneshp.dto.BrandDTO;
import com.lothin.phoneshp.model.Brand;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand toEntity(BrandDTO dto);

    BrandDTO toDTO(Brand entity);

    void update(@MappingTarget Brand target, Brand source);
}
