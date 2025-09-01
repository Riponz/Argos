package com.argos.tracker.personal_finance.repositories;

import com.argos.tracker.personal_finance.entities.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpenseRepo extends MongoRepository<Expense, String> {
    List<Expense> findByDateBetween(LocalDateTime start, LocalDateTime end);

    List<Expense> findByCategoryId(Integer categoryId); // because category is an object

    List<Expense> findByPaymentMethodIgnoreCase(String method);
}
