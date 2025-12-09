package com.webapp.webapp_be.services;

import com.webapp.webapp_be.dto.CategoryDTO;
import com.webapp.webapp_be.models.Category;

public interface ICategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(Long CategoryId, CategoryDTO categoryDTO);
    void getAllCategories();
    void getCategoryById(Long categoryId);
}
