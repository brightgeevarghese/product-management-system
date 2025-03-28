package com.bright.pms.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SSD extends Product {
    private Integer capacity;

    public SSD(String name, BigDecimal price, Integer capacity) {
        super(name, price);
        this.capacity = capacity;
    }
}
