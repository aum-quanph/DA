package com.webapp.webapp_be.services;

import com.webapp.webapp_be.dto.ProductDTO;
import com.webapp.webapp_be.models.Product;
import com.webapp.webapp_be.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .thumbnail(productDTO.getThumbnail())
                .categoryId(productDTO.getCategoryId())
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductDTO productDTO) {
        return null;
    }
}
