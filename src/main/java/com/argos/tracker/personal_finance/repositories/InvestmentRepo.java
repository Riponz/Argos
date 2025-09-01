package com.argos.tracker.personal_finance.repositories;

import com.argos.tracker.personal_finance.entities.Investment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvestmentRepo extends MongoRepository<Investment, String> {
}
