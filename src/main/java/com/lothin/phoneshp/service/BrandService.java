package com.lothin.phoneshp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lothin.phoneshp.model.Brand;


@Service
public interface BrandService {
    Brand save(Brand entity);
    Brand getById(Long id);
    Brand update(Long id , Brand brand);
    void delete(Long id);
    List<Brand> getBrands();
}
