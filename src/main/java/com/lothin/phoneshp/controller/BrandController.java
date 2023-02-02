package com.lothin.phoneshp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lothin.phoneshp.dto.BrandDTO;
import com.lothin.phoneshp.exception.ApiException;
import com.lothin.phoneshp.mapper.BrandMapper;
import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.service.BrandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
        Brand brand = BrandMapper.INSTANCE.toEntity(brandDTO);
        brand = brandService.save(brand);
        return ResponseEntity.ok(brand);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) throws ApiException {
        return ResponseEntity.ok(brandService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Brand> update(@PathVariable("id") Long id, @RequestBody BrandDTO brandDTO) throws ApiException {
        Brand brand = BrandMapper.INSTANCE.toEntity(brandDTO);
        return ResponseEntity.ok(brandService.update(id, brand));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) throws ApiException {
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<BrandDTO> brandList = brandService.getBrands()
                .stream()
                .map(b -> BrandMapper.INSTANCE.toDTO(b))
                .collect(Collectors.toList());
        return ResponseEntity.ok(brandList);
    }
}
