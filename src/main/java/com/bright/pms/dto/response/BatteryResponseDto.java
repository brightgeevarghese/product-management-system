package com.bright.pms.dto.response;

import java.math.BigDecimal;
import java.util.Map;

public record BatteryResponseDto(
        String name,
        BigDecimal price,
        Map<String, String> propertiesMapping,
        Boolean rechargeable
) implements ProductResponseDto {
}
