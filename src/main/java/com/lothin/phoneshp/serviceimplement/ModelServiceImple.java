package com.lothin.phoneshp.serviceimplement;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.lothin.phoneshp.dto.ModelDTO;
import com.lothin.phoneshp.exception.ResourceNotFoundException;
import com.lothin.phoneshp.mapper.ModelMapper;
import com.lothin.phoneshp.model.Model;
import com.lothin.phoneshp.repository.ModelRepository;
import com.lothin.phoneshp.service.BrandService;
import com.lothin.phoneshp.service.ModelService;
import com.lothin.phoneshp.spec.ModelFilter;
import com.lothin.phoneshp.spec.ModelSpec;

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
                .orElseThrow(() -> new ResourceNotFoundException("Model", id));

    }

    @Override
    public List<Model> getAllModels(Map<String, String> params) {
        ModelFilter modelFilter = new ModelFilter();
        if (params.containsKey("modelId")) {
            modelFilter.setBrandId(MapUtils.getInteger(params, "modelId"));
        }
        if (params.containsKey("modelName")) {
            modelFilter.setModelName(MapUtils.getString(params, "modelName"));
        }
        if (params.containsKey("brandId")) {
            modelFilter.setBrandId(MapUtils.getInteger(params, "brandId"));
        }
        if (params.containsKey("brandName")) {
            modelFilter.setBrandName(MapUtils.getString(params, "brandName"));
        }
        ModelSpec modelSpec = new ModelSpec(modelFilter);
        return modelRepository.findAll(modelSpec, Sort.by(Order.asc("id")));
    }

    // @Override
    // public List<Model> getAllModels(Map<String, String> params) {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Specification<Model> specification = new Specification<Model>() {
    // @Override
    // @Nullable
    // public Predicate toPredicate(Root<Model> model, CriteriaQuery<?> query,
    // CriteriaBuilder cb) {
    // if (params.containsKey("name")) {
    // String modelName = params.get("name");
    // Predicate predicatename = cb.like(model.get("name"), "%" + modelName + "%");
    // return predicatename;
    // }
    // return null;
    // }
    // };
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Specification<Model> specification = (Root<Model> model, CriteriaQuery<?>
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////// query,
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////// CriteriaBuilder
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////// cb)
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////// ->
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////// {
    // if (params.containsKey("name")) {
    // String modelName = params.get("name");
    // Predicate predicatename = cb.like(model.get("name"), "%" + modelName + "%");
    // return predicatename;
    // }
    // return null;
    // };
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Specification<Model> specification = ( model, query, cb) -> {
    // if (params.containsKey("name")) {
    // String modelName = params.get("name");
    // Predicate predicatename = cb.like(model.get("name"), "%" + modelName + "%");
    // return predicatename;
    // }
    // return null;
    // };
    // List<Model> list =
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////// modelRepository.findAll(specification,Sort.by(Order.asc("id")));
    // return list;
    // }

}
