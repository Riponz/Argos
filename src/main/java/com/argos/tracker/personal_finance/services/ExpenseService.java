package com.argos.tracker.personal_finance.services;

import com.argos.tracker.personal_finance.entities.Expense;
import com.argos.tracker.personal_finance.repositories.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    public ExpenseRepo expenseRepo;

    public void addExpense(Expense expense) {
        expenseRepo.save(expense);
    }

    public void deleteExpense(String id) {
        expenseRepo.deleteById(id);
    }

    public List<Expense> getAll() {
        List<Expense> expenses = expenseRepo.findAll();
        return expenses;
    }

//    FILTER METHODS

    public List<Expense> findByMonth(String month) {
        // month format = "2025-08"
        YearMonth ym = YearMonth.parse(month);
        LocalDateTime start = ym.atDay(1).atStartOfDay();
        LocalDateTime end = ym.atEndOfMonth().atTime(23, 59, 59);
        return expenseRepo.findByDateBetween(start, end);

    }

    public List<Expense> byCategory(Integer categoryId){
        return expenseRepo.findByCategoryId(categoryId);
    }

    public List<Expense> byRange(LocalDateTime start, LocalDateTime end){
        return expenseRepo.findByDateBetween(start, end);
    }
    
    public List<Expense> byMethod(String method){
        return expenseRepo.findByPaymentMethodIgnoreCase(method);
    }
}
