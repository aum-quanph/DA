package com.webapp.webapp_be.services;

import com.webapp.webapp_be.dto.CategoryDTO;
import com.webapp.webapp_be.models.Category;
import com.webapp.webapp_be.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = Category.builder()
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .image(categoryDTO.getImage())
                .build();
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Long CategoryId, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findCategoryById(CategoryId)
                .orElseThrow(() -> new RuntimeException("Cannot find category by id: " + CategoryId));

        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setImage(category.getImage());

        return categoryRepository.save(category);
    }

    @Override
    public void getAllCategories() {
        categoryRepository.findAll();
    }

    @Override
    public void getCategoryById(Long categoryId) {
        categoryRepository.findCategoryById(categoryId);
    }
}
