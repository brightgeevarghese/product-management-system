package com.bright.pms.dto.response;

import java.math.BigDecimal;
import java.util.Map;

public record SSDResponseDto(
        String name,
        BigDecimal price,
        Map<String, String> propertiesMapping,
        Integer capacity
) implements ProductResponseDto {
}
