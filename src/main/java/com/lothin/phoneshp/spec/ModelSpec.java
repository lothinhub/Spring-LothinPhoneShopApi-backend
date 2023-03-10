package com.lothin.phoneshp.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.model.Brand_;
import com.lothin.phoneshp.model.Model;
import com.lothin.phoneshp.model.Model_;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@RequiredArgsConstructor
public class ModelSpec implements Specification<Model> {
    private final ModelFilter modelFilter;

    @Override
    @Nullable
    public Predicate toPredicate(Root<Model> model, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();

        Join<Model, Brand> brand = model.join("brand");
        if (modelFilter.getModelId() != null) {
            Predicate modelId = model.get(Model_.ID).in(modelFilter.getModelId());
            list.add(modelId);
        }
        if (modelFilter.getModelName() != null) {
            Predicate modelName = cb.like(model.get(Model_.NAME), "%" + modelFilter.getModelName() + "%");
            list.add(modelName);
        }
        if (modelFilter.getBrandId() != null) {
            Predicate brandId = brand.get("id").in(modelFilter.getBrandId());
            list.add(brandId);
        }
        if (modelFilter.getBrandName() != null) {
            Predicate brandName = cb.like(brand.get(Brand_.NAME), "%" + modelFilter.getBrandName() + "%");
            list.add(brandName);
        }
        Predicate[] predicates = list.toArray(Predicate[]::new);
        return cb.and(predicates);
    }

}
