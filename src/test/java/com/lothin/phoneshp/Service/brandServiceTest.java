package com.lothin.phoneshp.Service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.lothin.phoneshp.exception.ApiException;
import com.lothin.phoneshp.model.Brand;
import com.lothin.phoneshp.repository.BrandRepository;
import com.lothin.phoneshp.service.BrandService;
import com.lothin.phoneshp.serviceimplement.BrandServiceImple;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class brandServiceTest {
    @Mock
    private BrandRepository brandRepository;
    private BrandService brandService;
    private Brand brand;
    @Captor
    private ArgumentCaptor<Brand> brandCaptor;

    @BeforeEach
    public void setup() {
        brandService = new BrandServiceImple(brandRepository);
        brand = new Brand(1, "Apple");
        when(brandRepository.findById(102)).thenReturn(Optional.of(brand));
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
        brandService.save(brand);
        verify(brandRepository, times(1)).save(brand);

        // ----------------------------------------------------------------
        // Brand brandReturn = brandService.save(brand);
        // ----------------------------------------------------------------
        // assertEquals("Apple", brandReturn.getName());
        // assertEquals(1, brandReturn.getId());
    }

    @Test
    public void getByIdSuccess() {
        // Brand brand = new Brand(1, "Apple");
        // when(brandRepository.findById(1)).thenReturn(Optional.of(brand));

        Brand brandReturn = brandService.getById(102);
        assertNotNull(brandReturn);
        assertEquals("Apple", brandReturn.getName());
        assertEquals(1, brandReturn.getId());
    }

    @Test
    public void getByIdThrowException() {
        //given
        
        //when 
        when(brandRepository.findById(102)).thenReturn(Optional.empty());
        //then
        assertThatThrownBy(()->brandService.getById(102))
        .isInstanceOf(ApiException.class)
        .hasMessageStartingWith("Brand Not Found For id=");
    }

    @Test
    public void testUpdateBrand() {

        // given
        Brand brandUpdate = new Brand(102, "Apple V");
        // when
        // when(brandRepository.findById(102)).thenReturn(Optional.of(fromDB));
        brandService.update(102, brandUpdate);
        // then
        // assertEquals(AfterUpdate.getName(), "Apple V");
        verify(brandRepository,atMostOnce()).findById(102);
        verify(brandRepository).save(brandCaptor.capture());
        // verify(brandRepository, times(1)).save(brandUpdate);
        assertEquals(brandCaptor.getValue().getName(), brandUpdate.getName());
    }

    @Test
    public void testDeleteBrand() {
        Integer brandDelete = 102;
        // Brand brand = new Brand(1, "Apple 2");
        // when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
        brandService.delete(brandDelete);
        verify(brandRepository, times(1)).delete(brand);
    }

    @Test
    public void testListBrand() {
        List<Brand> brandlist = List.of(
                new Brand(1, "Apple"),
                new Brand(2, "Samsung"));
        when(brandRepository.findAll()).thenReturn(brandlist);
        List<Brand> brandReturns = brandService.getAllBrands();

        assertEquals(2, brandReturns.size());
        assertEquals("Apple", brandReturns.get(0).getName());
        assertEquals("Samsung", brandReturns.get(1).getName());
    }
}
