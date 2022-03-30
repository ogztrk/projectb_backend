package com.badibul.backend.service;

import com.badibul.backend.entity.Category;
import com.badibul.backend.repository.CategoryRepository;
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

    public Set<Category> getCategories(Set<Long> categoryId) {

        return  categoryRepository.findAllByIdIn(categoryId);
    }

    /*public List<Category> getCategoryByEventId(Long eventId) {
        return categoryRepository.findByEvents_EventId(eventId);
    }*/
}