package com.courseapi.courseapi.service;

import com.courseapi.courseapi.entity.Category;
import com.courseapi.courseapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    public Category getCategory(long id) {
        return categoryRepository.findById( id )
                .orElseThrow( ()-> new IllegalArgumentException("Not found"));
    }

    public Category createCategory(@RequestBody Category category) {
        Optional<Category> categoryisThere = categoryRepository.findByName( category.getName());
        if (categoryisThere.isPresent()) {
            throw new RuntimeException( "This category already exist" );
        }
        return categoryRepository.save( category );
    }

    public Category updateCategory(long id, Category category) {
        Category foundCategory = getCategory( id );
        foundCategory.setName( category.getName() );
        return categoryRepository.save( foundCategory );
    }

    public String deleteCategory(long id) {
        Category foundCategory = getCategory( id );
        categoryRepository.delete( foundCategory );
        return "Category deleted";
    }
}
