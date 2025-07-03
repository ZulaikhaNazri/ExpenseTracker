package com.SpringBootMVC.ExpensesTracker.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.SpringBootMVC.ExpensesTracker.entity.Expense;
import com.SpringBootMVC.ExpensesTracker.service.ExpenseService;

@RestController
@RequestMapping("/api") 
public class ExpenseRestController {
    @Autowired ExpenseService expenseService;

    @GetMapping("/expenses/{userId}")
    public List<Expense> getExpenses(@PathVariable int userId) {
        return expenseService.findAllExpensesByClientId(userId);
    }
}
