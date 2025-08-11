package com.argos.tracker.personal_finance.repositories;

import com.argos.tracker.personal_finance.entities.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepo extends MongoRepository<Expense, String> {
}
