package com.lothin.phoneshp.controller;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// import com.lothin.phoneshp.dto.ProductDTO2;
import com.lothin.phoneshp.dto.PriceDTO;
import com.lothin.phoneshp.dto.PageDTO;
import com.lothin.phoneshp.mapper.ProductMapper;
import com.lothin.phoneshp.model.Product;
import com.lothin.phoneshp.dto.ProductImportDTO;
import com.lothin.phoneshp.mapper.PageMapper;
import com.lothin.phoneshp.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductImportDTO dto) {
        return ResponseEntity.ok(productMapper.toDTO(productService.save(dto)));
    }

    @PutMapping("/setPrice/{productId}")
    public ResponseEntity<?> setPrice(@PathVariable("productId") Long productId,
            @RequestBody PriceDTO priceDTO) {
        Product product = productService.setPrice(productId,
                priceDTO.getSalePrice());
        return ResponseEntity.ok(productMapper.toDTO(product));
    }

    @GetMapping
    public ResponseEntity<?> listProducts(@RequestParam Map<String, String> params) {
        Page<Product> productPage = productService.getProducts(params);

        PageDTO pageDTO = PageMapper.INSTANCE.toDTO(productPage);
        pageDTO.setList(productService.toProductDisplayDTOs(productPage.getContent()));

        return ResponseEntity.ok(pageDTO);
    }
}