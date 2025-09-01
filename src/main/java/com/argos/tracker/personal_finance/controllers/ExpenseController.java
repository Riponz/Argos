package com.argos.tracker.personal_finance.controllers;


import com.argos.tracker.personal_finance.entities.Category;
import com.argos.tracker.personal_finance.entities.Expense;
import com.argos.tracker.personal_finance.entities.Filter;
import com.argos.tracker.personal_finance.services.CategoryService;
import com.argos.tracker.personal_finance.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<?> allExpenses() {
        List<Expense> expenses = expenseService.getAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add_expense(@RequestBody Expense expense) {

        if (expense.getCategoryId() != null) {

            Category category = categoryService.findById(expense.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));

            expense.setCategory(category);

            expenseService.addExpense(expense);

        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //FILTER METHODS
    @PostMapping("/by-month")
    public ResponseEntity<?> expensesByMonth(@RequestBody Filter date) {
        List<Expense> monthlyExpenses = expenseService.findByMonth(date.getYearMonth());
        return new ResponseEntity<>(monthlyExpenses, HttpStatus.OK);
    }


    @PostMapping("/by-category")
    public ResponseEntity<?> expensesByCategory(@RequestBody Filter filter) {

        List<Expense> categoryExpenses = expenseService.byCategory(filter.getCategoryId());

        return new ResponseEntity<>(categoryExpenses, HttpStatus.OK);
    }

    @PostMapping("/by-range")
    public ResponseEntity<?> expensesByWeek(@RequestBody Filter filter) {
        List<Expense> rangeExpenses = expenseService.byRange(filter.getStart(), filter.getEnd());
        return new ResponseEntity<>(rangeExpenses, HttpStatus.OK);
    }

    @PostMapping("/by-payment-method")
    public ResponseEntity<?> expensesByPaymentMethod(@RequestBody Filter filter) {
        List<Expense> methodExpnses = expenseService.byMethod(filter.getMethod());
        return new ResponseEntity<>(methodExpnses, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
