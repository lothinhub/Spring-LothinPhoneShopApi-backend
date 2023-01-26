package com.lothin.phoneshp.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lothin.phoneshp.dto.BrandDTO;
import com.lothin.phoneshp.exception.ApiException;
import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.repository.BrandRepository;
import com.lothin.phoneshp.service.BrandService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImple implements BrandService {
    @Autowired
    private final BrandRepository brandRepository;

    @Override
    public Brand save(Brand entity) {
        return brandRepository.save(entity);
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Brand Not Found For id=%d", id)));
        
    }

    @Override
    public Brand update(Integer id, BrandDTO dto) {
        Brand brand = getById(id);
        brand.setName(dto.getName());
        brandRepository.save(brand);    
        return brand;
    }

    @Override
    public void delete(Integer id) {
        Brand brand = getById(id);
        brandRepository.delete(brand);
        log.info("Brand with id =%d ".formatted(id));
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
