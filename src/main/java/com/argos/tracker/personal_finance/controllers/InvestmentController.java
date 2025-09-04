package com.argos.tracker.personal_finance.controllers;


import com.argos.tracker.personal_finance.entities.Investment;
import com.argos.tracker.personal_finance.services.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping("/all")
    public ResponseEntity<?> getInvestments(){
        List<Investment> allInvestments = investmentService.getAll();
        return new ResponseEntity<>(allInvestments, HttpStatus.OK);

    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Investment investment){
        investmentService.add(investment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
