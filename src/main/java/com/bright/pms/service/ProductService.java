package com.bright.pms.service;

import com.bright.pms.dto.request.ProductRequestDto;
import com.bright.pms.dto.response.ProductResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductResponseDto> createSSD(ProductRequestDto dto, Integer capacity);
    Optional<ProductResponseDto> createBattery(ProductRequestDto dto, Boolean rechargeable);
    List<ProductResponseDto> getAllProducts();
    Optional<ProductResponseDto> getProductById(Long id);
    void deleteProduct(Long id);
}
