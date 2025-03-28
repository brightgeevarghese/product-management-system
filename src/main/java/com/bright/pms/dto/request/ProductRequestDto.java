package com.bright.pms.dto.request;

import java.math.BigDecimal;
import java.util.Map;

public record ProductRequestDto(
        String name,
        BigDecimal price,
        Map<String, String> propertiesMapping
) {
}
