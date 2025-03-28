package com.bright.pms.service.impl;

import com.bright.pms.dto.request.ProductRequestDto;
import com.bright.pms.dto.response.BatteryResponseDto;
import com.bright.pms.dto.response.ProductResponseDto;
import com.bright.pms.dto.response.SSDResponseDto;
import com.bright.pms.model.Battery;
import com.bright.pms.model.Product;
import com.bright.pms.model.SSD;
import com.bright.pms.repository.BatteryRepository;
import com.bright.pms.repository.ProductRepository;
import com.bright.pms.repository.SSDRepository;
import com.bright.pms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BatteryRepository batteryRepository;
    private final SSDRepository ssdRepository;

    @Override
    public Optional<ProductResponseDto> createSSD(ProductRequestDto dto, Integer capacity) {
        SSD ssd = new SSD(dto.name(), dto.price(), capacity);
        ssd.setPropertiesMapping(dto.propertiesMapping());
        SSD savedProduct = ssdRepository.save(ssd);
        ProductResponseDto productResponseDto = new SSDResponseDto(savedProduct.getName(), savedProduct.getPrice(), savedProduct.getPropertiesMapping(), savedProduct.getCapacity());
        return Optional.of(productResponseDto);
    }

    @Override
    public Optional<ProductResponseDto> createBattery(ProductRequestDto dto, Boolean rechargeable) {
        Battery battery = new Battery(dto.name(), dto.price(), rechargeable);
        battery.setPropertiesMapping(dto.propertiesMapping());
        Battery savedProduct = batteryRepository.save(battery);
        ProductResponseDto productResponseDto = new BatteryResponseDto(savedProduct.getName(), savedProduct.getPrice(), savedProduct.getPropertiesMapping(), savedProduct.getRechargeable());
        return Optional.of(productResponseDto);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    if (product instanceof Battery battery) {
                        return new BatteryResponseDto(battery.getName(), battery.getPrice(), battery.getPropertiesMapping(), battery.getRechargeable());
                    } else if (product instanceof SSD ssd) {
                        return new SSDResponseDto(ssd.getName(), ssd.getPrice(), ssd.getPropertiesMapping(), ssd.getCapacity());
                    } else {
                        throw new IllegalStateException("Unknown product type: " + product.getClass().getSimpleName());
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductResponseDto> getProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
