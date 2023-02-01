package com.lothin.phoneshp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

// import com.lothin.phoneshp.model.Color;
// import com.lothin.phoneshp.model.Model;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Integer modelId;
    private Short yearMade;
    // private Integer colorId;
    private BigDecimal importPrice;
    private double salePrice;
    private LocalDate importDate;
    private String imagePath;

}
