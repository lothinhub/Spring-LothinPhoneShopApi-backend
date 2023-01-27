package com.lothin.phoneshp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lothin.phoneshp.model.Brand;


@Service
public interface BrandService {
    Brand save(Brand entity);
    Brand getById(Integer id);
    Brand update(Integer id , Brand brand);
    void delete(Integer id);
    List<Brand> getAllBrands();
}
