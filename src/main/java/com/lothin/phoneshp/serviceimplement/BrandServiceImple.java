package com.lothin.phoneshp.serviceimplement;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    // private Brand brand;
    @Override
    public Brand save(Brand entity) {
        return brandRepository.save(entity);
    }

    @Override
    public Brand getById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(
                        () -> new ApiException(HttpStatus.NOT_FOUND, String.format("Brand Not Found For id=%d", id)));

    }

    @Override
	public Brand update(Long id, Brand source) {
		Brand target = getById(id);
		// source.setId(id);
		// BrandMapper.INSTANCE.update(target, source);
		BeanUtils.copyProperties(source, target, "id");
		// target.setName("Apple was update");
		return brandRepository.save(target);
	}

    @Override
    public void delete(Long id) {
        Brand brand = getById(id);
        // brandRepository.delete(brand);
        brand.setActive(false);
        brandRepository.save(brand);
        log.info("Brand with id =%d ".formatted(id));
    }

    @Override
    public List<Brand> getBrands() {
        // boolean ByName = brandRepository.existsByName("vivo");
        // System.out.println(ByName);
        return brandRepository.findByActiveTrue();
    }
}
