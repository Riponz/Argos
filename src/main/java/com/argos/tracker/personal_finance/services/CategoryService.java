package com.argos.tracker.personal_finance.services;

import com.argos.tracker.personal_finance.entities.Category;
import com.argos.tracker.personal_finance.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public void saveCategory(Category category){
        categoryRepo.save(category);
    }

    public List<Category> categories(){
        List<Category> categories = categoryRepo.findAll();
        return categories;
    }
}
