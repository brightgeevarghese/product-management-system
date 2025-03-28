package com.bright.pms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(name = "products")
//@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private BigDecimal price;
    @ElementCollection
    @CollectionTable(name = "product_properties", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "property_key")
    @Column(name = "property_value")
    private Map<String, String> propertiesMapping = new HashMap<>();

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
