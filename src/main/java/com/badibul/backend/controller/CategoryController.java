package com.badibul.backend.controller;

import com.badibul.backend.entity.Category;
import com.badibul.backend.entity.Comment;
import com.badibul.backend.request.CategoryCreateRequest;
import com.badibul.backend.request.CategoryUpdateRequest;
import com.badibul.backend.request.CommentCreateRequest;
import com.badibul.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){

        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId){

        return categoryService.getOneCategory(categoryId);
    }
    @PostMapping
    public Category createOneCategory(@RequestBody CategoryCreateRequest categoryCreateRequest){

        return  categoryService.createOneCategory(categoryCreateRequest);
    }
    @PutMapping("/{categoryId}")
    public Category updateOneCategory(@PathVariable Long categoryId,@RequestBody CategoryUpdateRequest categoryUpdateRequest){
        return categoryService.updateOneCategory(categoryId,categoryUpdateRequest);
    }
    @DeleteMapping("/{categoryId}")
    public void deleteOneCategory(@PathVariable Long categoryId){
        categoryService.deleteOneCategory(categoryId);

    }

}
