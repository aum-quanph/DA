package com.webapp.webapp_be.services;

import com.webapp.webapp_be.dto.ProductDTO;
import com.webapp.webapp_be.models.Category;
import com.webapp.webapp_be.models.Product;
import com.webapp.webapp_be.repository.CategoryRepository;
import com.webapp.webapp_be.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findCategoryById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Cannot find Category by id!"));

        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .thumbnail(productDTO.getThumbnail())
                .category(category)
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(@PathVariable("id") Long productId, ProductDTO productDTO) {
        Product existProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Cannot find product with id: " + productId));

        Category category = categoryRepository.findCategoryById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Cannot find category with id: " + productDTO.getCategoryId()));

        existProduct.setName(productDTO.getName());
        existProduct.setPrice(productDTO.getPrice());
        existProduct.setThumbnail(productDTO.getThumbnail());
        existProduct.setDescription(productDTO.getDescription());
        existProduct.setCategory(category);

        return productRepository.save(existProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Cannot find product with id: " + productId));
    }
}
