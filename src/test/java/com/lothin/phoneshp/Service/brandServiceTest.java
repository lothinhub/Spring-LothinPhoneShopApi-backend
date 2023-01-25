package com.lothin.phoneshp.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
// import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
// import org.mockito.stubbing.Answer;

import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.repository.BrandRepository;
import com.lothin.phoneshp.service.BrandService;
import com.lothin.phoneshp.serviceimplement.BrandServiceImple;

@ExtendWith(MockitoExtension.class)
public class brandServiceTest {
    @Mock
    private BrandRepository brandRepository;
    private BrandService brandService;

    @BeforeEach
    public void Test() {
        brandService = new BrandServiceImple(brandRepository);
    }

    // @Test
    public void testServiceBrand() {

        // given
        // ------------------------
        Brand brand = new Brand();
        brand.setName("Apple");
        // --------------------------
        // when
        /*
         * when(brandRepository.save(any(Brand.class))).thenAnswer(new Answer<Brand>() {
         * 
         * @Override
         * public Brand answer(InvocationOnMock invocation) throws Throwable {
         * Brand brandEntity = invocation.getArgument(0);
         * brandEntity.setId(1);
         * return brandEntity;
         * }
         * });
         */
        /*
         * when(brandRepository.save(any(Brand.class))).thenAnswer(invocation -> {
         * Brand brandEntity = invocation.getArgument(0);
         * brandEntity.setId(1);
         * return brandEntity;
         * });
         */

        verify(brandRepository, times(1)).save(brand);

        // ----------------------------------------------------------------
        // Brand brandReturn = brandService.save(brand);
        // ----------------------------------------------------------------
        // assertEquals("Apple", brandReturn.getName());
        // assertEquals(1, brandReturn.getId());
    }

    @Test
    public void getByIdSuccess() {
        Brand brand = new Brand(1, "Apple");
        when(brandRepository.findById(1)).thenReturn(Optional.of(brand));

        Brand brandReturn = brandService.getById(1);
        assertNotNull(brandReturn);
        assertEquals("Apple", brandReturn.getName());
        assertEquals(1, brandReturn.getId());
    }
    @Test
    public void getByIdError() {

    }
}
