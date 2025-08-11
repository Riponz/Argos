package com.argos.tracker.personal_finance.services;

import com.argos.tracker.personal_finance.entities.Expense;
import com.argos.tracker.personal_finance.repositories.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    public ExpenseRepo expenseRepo;

    public void addExpense(Expense expense){

        expenseRepo.save(expense);

    }

    public List<Expense> getAll(){
        List<Expense> expenses = expenseRepo.findAll();
        return expenses;
    }
}
