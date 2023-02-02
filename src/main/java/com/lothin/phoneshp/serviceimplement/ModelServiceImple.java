package com.lothin.phoneshp.serviceimplement;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

// import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.exception.ResourceNotFoundException;
// import com.lothin.phoneshp.mapper.ModelMapper;
import com.lothin.phoneshp.model.Model;
import com.lothin.phoneshp.repository.ModelRepository;
// import com.lothin.phoneshp.service.BrandService;
import com.lothin.phoneshp.service.ModelService;
import com.lothin.phoneshp.spec.ModelFilter;
import com.lothin.phoneshp.spec.ModelSpec;
import com.lothin.phoneshp.utils.PageUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelServiceImple implements ModelService {
    private final ModelRepository modelRepository;
    // private final BrandService brandService;

    @Override
    public Model save(Model entity) {

        return modelRepository.save(entity);
    }

    @Override
    public Model getById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Model", id));

    }

    @Override
    public Page<Model> getModels(Map<String, String> params) {
        Pageable pageable = PageUtils.getPageable(params);

        ModelFilter modelFilter = new ModelFilter();
        if (params.containsKey("modelId")) {
            modelFilter.setModelId(MapUtils.getLong(params, "modelId"));
        }
        if (params.containsKey("modelName")) {
            modelFilter.setModelName(MapUtils.getString(params, "modelName"));
        }
        if (params.containsKey("brandId")) {
            modelFilter.setBrandId(MapUtils.getLong(params, "brandId"));
        }
        if (params.containsKey("brandName")) {
            modelFilter.setBrandName(MapUtils.getString(params, "brandName"));
        }

        ModelSpec modelSpec = new ModelSpec(modelFilter);

        Page<Model> page = modelRepository.findAll(modelSpec, pageable);
        return page;
    }

}
