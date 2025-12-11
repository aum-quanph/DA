package com.webapp.webapp_be.services.products;

import com.webapp.webapp_be.dto.ProductDTO;
import com.webapp.webapp_be.dto.ProductImageDTO;
import com.webapp.webapp_be.models.Product;
import com.webapp.webapp_be.models.ProductImage;

import java.util.List;

public interface IProductService {
    Product createProduct(ProductDTO productDTO);
    Product updateProduct(Long productId, ProductDTO productDTO);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO) throws Exception;
}
