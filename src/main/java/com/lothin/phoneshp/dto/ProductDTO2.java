package com.lothin.phoneshp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ProductDTO2 {
    private Long id;
    private String name;
    private Long modelId;
    private Long colorId;
    private BigDecimal importPrice;
    private double salePrice;
    private LocalDate importDate;
    private String imagePath;

}
