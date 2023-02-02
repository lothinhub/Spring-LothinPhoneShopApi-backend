package com.lothin.phoneshp.dto;

import lombok.Data;

@Data
public class ProductImportDTO {
    private ProductDTO product;
    private ImportDTO importDetail;

}
