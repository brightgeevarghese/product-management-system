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
public class Battery extends Product {

    private Boolean rechargeable;

    public Battery(String name, BigDecimal price, Boolean rechargeable) {
        super(name, price);
        this.rechargeable = rechargeable;
    }
}
