package com.badibul.backend.service;

import com.badibul.backend.entity.Category;
import com.badibul.backend.repository.CategoryRepository;
import com.badibul.backend.request.CategoryCreateRequest;
import com.badibul.backend.request.CategoryUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category getOneCategory(Long categoryId) {

        return  categoryRepository.findById(categoryId).orElseThrow(null);
    }

    public List<Category> getAllCategories() {

        return  categoryRepository.findAll();
    }


    public Category createOneCategory(CategoryCreateRequest categoryCreateRequest) {
        Category newCategory= new Category();
        newCategory.setFoto(categoryCreateRequest.getFoto());
        newCategory.setName(categoryCreateRequest.getName());
        return categoryRepository.save(newCategory);
    }

    public Category updateOneCategory(Long categoryId,CategoryUpdateRequest categoryUpdateRequest) {

        Optional<Category> category= categoryRepository.findById(categoryId);
        if(category.isPresent()){
        Category updatedCategory= new Category();
        updatedCategory= category.get();
        updatedCategory.setName(categoryUpdateRequest.getName());
        updatedCategory.setFoto(categoryUpdateRequest.getFoto());
        return categoryRepository.save(updatedCategory);
        }
         return null;
    }


    public void deleteOneCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}