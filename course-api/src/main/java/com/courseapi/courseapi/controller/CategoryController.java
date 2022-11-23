package com.courseapi.courseapi.controller;

import com.courseapi.courseapi.entity.Category;
import com.courseapi.courseapi.entity.Course;
import com.courseapi.courseapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategory(){
        return categoryService.getCategory();
    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable long id) {
        return categoryService.getCategory(id);
    }
    @PostMapping()
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory( category);
    }
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable  long id, @RequestBody Category category) {
        return categoryService.updateCategory( id, category );
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable  long id) {
        return categoryService.deleteCategory( id );
    }

}
