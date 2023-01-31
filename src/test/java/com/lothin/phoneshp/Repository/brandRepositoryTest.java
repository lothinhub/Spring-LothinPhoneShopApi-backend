package com.lothin.phoneshp.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.repository.BrandRepository;

@DataJpaTest
public class brandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    public void setUp() {
        brandRepository.deleteAll();
    }

    @Test
    public void existsByName() {
        // given
        Brand brand = new Brand();
        brand.setName("oppo");
        brandRepository.save(brand);
        // when
        Boolean success = brandRepository.existsByName("oppo");
        Boolean failure = brandRepository.existsByName("Samsung");
        // then
        assertTrue(success);
        assertFalse(failure);
    }

    @Test
    public void testFindById() {

        Brand brand1 = new Brand("Appple");
        Brand brand2 = new Brand("Samsung");
        brandRepository.save(brand1);
        brandRepository.save(brand2);
        List<Brand> brand = brandRepository.findByIdIn(List.of(1, 2));
        assertEquals(2, brand.size());

        assertEquals(1, brand.get(0).getId());
        assertEquals("Apple", brand.get(0).getName());

        assertEquals(2, brand.get(1).getId());
        assertEquals("Samsung", brand.get(1).getName());

        // List<Brand> findAll = brandRepository.findAll();
        // assertEquals(2, findAll.size());
    }

    // @Test
    // public void testFindAll() {
    //     List<Brand> findAll = brandRepository.findAll();
    //     assertEquals(0, findAll.size());
    // }

}
