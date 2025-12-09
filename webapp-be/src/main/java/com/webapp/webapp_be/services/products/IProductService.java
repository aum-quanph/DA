package com.webapp.webapp_be.services.products;

import com.webapp.webapp_be.dto.ProductDTO;
import com.webapp.webapp_be.models.Product;

import java.util.List;

public interface IProductService {
    Product createProduct(ProductDTO productDTO);
    Product updateProduct(Long productId, ProductDTO productDTO);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
}
