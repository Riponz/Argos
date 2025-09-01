package com.argos.tracker.personal_finance.services;

import com.argos.tracker.personal_finance.entities.Investment;
import com.argos.tracker.personal_finance.repositories.InvestmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepo investmentRepo;

    public List<Investment> getAll(){
        return investmentRepo.findAll();
    }

    public void add(Investment investment){
        investmentRepo.save(investment);
    }
}
