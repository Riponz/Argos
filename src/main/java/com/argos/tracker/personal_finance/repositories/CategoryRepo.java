package com.argos.tracker.personal_finance.repositories;

import com.argos.tracker.personal_finance.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends MongoRepository<Category, Integer> {
}
