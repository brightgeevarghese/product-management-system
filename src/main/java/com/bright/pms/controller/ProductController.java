package com.bright.pms.controller;

import com.bright.pms.dto.request.ProductRequestDto;
import com.bright.pms.dto.response.ProductResponseDto;
import com.bright.pms.model.Product;
import com.bright.pms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/ssd")
    public ResponseEntity<ProductResponseDto> createSSD(@RequestBody ProductRequestDto productRequestDto, @RequestParam Integer capacity) {
        Optional<ProductResponseDto> productResponseDto = productService.createSSD(productRequestDto, capacity);
        if (productResponseDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/battery")
    public ResponseEntity<ProductResponseDto> createBattery(@RequestBody ProductRequestDto productRequestDto, @RequestParam Boolean rechargeable) {
        Optional<ProductResponseDto> productResponseDto = productService.createBattery(productRequestDto, rechargeable);
        if (productResponseDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
