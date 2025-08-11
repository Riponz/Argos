package com.argos.tracker.personal_finance.controllers;


import com.argos.tracker.personal_finance.entities.Expense;
import com.argos.tracker.personal_finance.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/all")
    public ResponseEntity<?> allExpenses(){
        List<Expense> expenses = expenseService.getAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add_expense(@RequestBody Expense expense){
//        System.out.println(expense.getDate().getDayOfMonth());
        expenseService.addExpense(expense);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
