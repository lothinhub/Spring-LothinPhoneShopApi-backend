package com.lothin.phoneshp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.lothin.phoneshp.mapper.EntityMapper;
import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.service.BrandService;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
        Brand brand = EntityMapper.toBrand(brandDTO);
        brand = brandService.save(brand);
        return ResponseEntity.ok(brand);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(brandService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Brand> update(@PathVariable("id") int id, @RequestBody BrandDTO brandDTO) {
        return ResponseEntity.ok(brandService.update(id, brandDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<BrandDTO> brandList = brandService.getAllBrands()
                .stream()
                .map(b -> EntityMapper.toBrandDTO(b))
                // .toList();
                .collect(Collectors.toList());
        return ResponseEntity.ok(brandList);
    }
}
