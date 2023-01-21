package com.lothin.phoneshp.mapper;

import com.lothin.phoneshp.dto.BrandDTO;
import com.lothin.phoneshp.model.Brand;

public class EntityMapper {
    public static Brand toBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        return brand;
    }

    public static BrandDTO toBrandDTO(Brand entity) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName(entity.getName());
        return brandDTO;
    }
}
