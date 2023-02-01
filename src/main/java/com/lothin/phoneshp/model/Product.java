package com.lothin.phoneshp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "${cannot.be.blank}")
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    @NotNull(message = "${required.Field}")
    @Column(name = "year_made")
    private Short yearMade;
    // @ManyToOne
    // @JoinColumn(name = "color_id")
    // private Color color;
    @DecimalMin(value = "0.000001")
    @Column(name = "import_price")
    private double importPrice;
    @Column(name = "sale_price")
    private double salePrice;
    @Column(name = "import_date")
    private LocalDate importDate;
    // private Integer numberOfUnit;
    @Column(name = "image_path")
    private String imagePath;
}
