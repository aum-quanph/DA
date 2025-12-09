package com.webapp.webapp_be.services.categories;

import com.webapp.webapp_be.dto.CategoryDTO;
import com.webapp.webapp_be.models.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category updateCategory(Long CategoryId, CategoryDTO categoryDTO);
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);
}
