package com.lothin.phoneshp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brands", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(generator = "brand_seq_generator")
    @SequenceGenerator(name = "brand_seq_generator", initialValue = 1, sequenceName = "brand_seq")
    private Integer id;
    private String name;

    public Brand(String name) {
        this.name = name;
    }
}
