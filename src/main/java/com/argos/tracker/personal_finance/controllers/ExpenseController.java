package com.argos.tracker.personal_finance.controllers;


import com.argos.tracker.personal_finance.entities.Category;
import com.argos.tracker.personal_finance.entities.Expense;
import com.argos.tracker.personal_finance.repositories.CategoryRepo;
import com.argos.tracker.personal_finance.services.CategoryService;
import com.argos.tracker.personal_finance.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<?> allExpenses(){
        List<Expense> expenses = expenseService.getAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add_expense(@RequestBody Expense expense){

        if(expense.getCategoryId() != null){

            Category category = categoryService.findById(expense.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));

            expense.setCategory(category);

            expenseService.addExpense(expense);

        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //FILTER METHODS
    @PostMapping("/by-month")
    public void expensesByMonth(@RequestBody String month){}

    @PostMapping("/by-category")
    public void expensesByCategory(@RequestBody String category){}

    @PostMapping("/by-week")
    public void expensesByWeek(@RequestBody LocalDateTime start, @RequestBody LocalDateTime end){}

    @PostMapping("/by-time")
    public void expensesByTime(@RequestBody LocalDateTime start, @RequestBody LocalDateTime end){}

    @PostMapping("/by-payment-method")
    public void expensesByPaymentMethod(@RequestBody String method){}


}
