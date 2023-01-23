package com.lothin.phoneshp.serviceimplement;

import org.springframework.stereotype.Service;

import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.mapper.ModelMapper;
import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.model.Model;
import com.lothin.phoneshp.repository.ModelRepository;
import com.lothin.phoneshp.service.BrandService;
import com.lothin.phoneshp.service.ModelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImple implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    @Override
    public Model save(ModelDTO dto) {
        Integer brandId = dto.getBrandDTO().getId();
        Brand brand = brandService.getById(brandId);

        Model model = ModelMapper.INSTANCE.toModel(dto);
        return modelRepository.save(model);
    }

}
