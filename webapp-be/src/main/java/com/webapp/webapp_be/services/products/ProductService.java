package com.webapp.webapp_be.services.products;

import com.webapp.webapp_be.dto.ProductDTO;
import com.webapp.webapp_be.dto.ProductImageDTO;
import com.webapp.webapp_be.exceptions.DataNotFoundException;
import com.webapp.webapp_be.exceptions.InvalidParamException;
import com.webapp.webapp_be.models.Category;
import com.webapp.webapp_be.models.Product;
import com.webapp.webapp_be.models.ProductImage;
import com.webapp.webapp_be.repository.CategoryRepository;
import com.webapp.webapp_be.repository.ProductImageRepository;
import com.webapp.webapp_be.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;

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

    @Override
    public ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO) throws Exception {
        Product existingProduct = productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "Cannot find product with id: "+productImageDTO.getProductId()));
        ProductImage newProductImage = ProductImage.builder()
                .product(existingProduct)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        //Ko cho insert quá 5 ảnh cho 1 sản phẩm
        int size = productImageRepository.findByProductId(productId).size();
        if(size >= ProductImage.MAXIMUM_IMAGES_PER_PRODUCT) {
            throw new InvalidParamException(
                    "Number of images must be <= "
                            +ProductImage.MAXIMUM_IMAGES_PER_PRODUCT);
        }
        return productImageRepository.save(newProductImage);
    }
}
