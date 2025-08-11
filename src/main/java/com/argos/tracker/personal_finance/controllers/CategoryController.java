package com.argos.tracker.personal_finance.controllers;

import com.argos.tracker.personal_finance.entities.Category;
import com.argos.tracker.personal_finance.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<?> allCategories(){
        List<Category> categories = categoryService.categories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
