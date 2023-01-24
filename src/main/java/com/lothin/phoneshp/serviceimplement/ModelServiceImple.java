package com.lothin.phoneshp.serviceimplement;

import org.springframework.stereotype.Service;

import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.exception.ResourceNotFoundException;
import com.lothin.phoneshp.mapper.ModelMapper;
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
        brandService.getById(brandId);

        Model model = ModelMapper.INSTANCE.toModel(dto);
        return modelRepository.save(model);
    }

    @Override
    public Model getById(Integer id) {
        return modelRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Model",id));
        
    }

}
