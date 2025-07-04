package com.SpringBootMVC.ExpensesTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SpringBootMVC.ExpensesTracker.DTO.ExpenseDTO;
import com.SpringBootMVC.ExpensesTracker.entity.Expense;
import com.SpringBootMVC.ExpensesTracker.service.ExpenseService;

@RestController
@RequestMapping("/api")
public class ExpenseRestController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expenses/{userId}")
    public List<Expense> getExpenses(@PathVariable int userId) {
        return expenseService.findAllExpensesByClientId(userId);
    }

    @PostMapping("/expenses/add")
    public ResponseEntity<String> addExpenses(@RequestBody ExpenseDTO expense) {
        try{
            expenseService.save(expense);
            return ResponseEntity.ok("Expense created successfully.");
        } catch (Exception e) { 
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
