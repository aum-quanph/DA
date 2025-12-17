package com.webapp.webapp_be.controllers;

import com.webapp.webapp_be.dto.CategoryDTO;
import com.webapp.webapp_be.models.Category;
import com.webapp.webapp_be.services.categories.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            Category newCategory = categoryService.createCategory(categoryDTO);
            return ResponseEntity.ok(newCategory);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(
            @PathVariable("id") Long categoryId,
            @RequestBody CategoryDTO categoryDTO) {
        try {
            Category updateCategory = categoryService.updateCategory(categoryId, categoryDTO);
            return ResponseEntity.ok(String.format("Update category with id = %d sucessfull", categoryId));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(categoryService.getCategoryById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            return ResponseEntity.ok(categoryService.getAllCategories());
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
