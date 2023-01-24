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
import com.lothin.phoneshp.model.Model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ModelSpec implements Specification<Model> {
    private final ModelFilter modelFilter;

    @Override
    @Nullable
    public Predicate toPredicate(Root<Model> model, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();
        Join<Model, Brand> brand = model.join("brand");

        if (modelFilter.getModelId() != null) {
            Predicate modelId = model.get("id").in(modelFilter.getModelId());
            list.add(modelId);
        }
        if (modelFilter.getModelName() != null) {
            Predicate modelName =  cb.like(model.get("name"), "%" + modelFilter.getModelName() + "%");
            list.add(modelName);
        }
        if (modelFilter.getBrandId() != null) {
            Predicate modelBrandId = model.get("id").in(modelFilter.getBrandId());
            list.add(modelBrandId);
        }
        if (modelFilter.getBrandName() != null) {
            Predicate modelBrandName = cb.like(brand.get("name"), "%" + modelFilter.getBrandName() + "%");
            list.add(modelBrandName);
        }
        Predicate[] predicates = list.toArray(Predicate[]::new);
        return cb.and(predicates);
    }

}
