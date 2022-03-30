package com.badibul.backend.controller;

import com.badibul.backend.entity.Category;
import com.badibul.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

   /* @GetMapping
    public Set<Category> getAllCategories(@RequestParam Set<Long> eventId){

        return categoryService.getCategoryByEventId(eventId);
    }*/

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId){

        return categoryService.getOneCategory(categoryId);
    }
}
