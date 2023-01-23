package com.lothin.phoneshp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.model.Model;

@Mapper
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "brand", source = "brandDTO")
    Model toModel(ModelDTO dto);

    @Mapping(target = "brandDTO", source = "brand")
    ModelDTO toDTO(Model entity);
}
