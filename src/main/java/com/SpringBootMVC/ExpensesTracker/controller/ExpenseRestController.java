package com.SpringBootMVC.ExpensesTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SpringBootMVC.ExpensesTracker.DTO.ExpenseDTO;
import com.SpringBootMVC.ExpensesTracker.entity.Expense;
import com.SpringBootMVC.ExpensesTracker.service.ExpenseService;

//The controller class responsible for handling REST API requests related to expenses
@RestController
@RequestMapping("/api") // Base URL mapping for all the methods in this controller
public class ExpenseRestController {
	// Automatically injects the ExpenseService into this controller to manage expenses
    @Autowired
    ExpenseService expenseService;

    // Endpoint to fetch all expenses for a specific user based on userId
    @GetMapping("/expenses/{userId}")
    public List<Expense> getExpenses(@PathVariable int userId) {
    	// Calling the service method to retrieve all expenses for the user with the provided userId
        return expenseService.findAllExpensesByClientId(userId);
    }

 // Endpoint to add a new expense by receiving data as ExpenseDTO in the request body
    @PostMapping("/expenses/add")
    public ResponseEntity<String> addExpenses(@RequestBody ExpenseDTO expense) {
        try{
        	// Calling the service to save the new expense
            expenseService.save(expense);
            // Returning a success response with HTTP status 200 (OK)
            return ResponseEntity.ok("Expense created successfully.");
        } catch (Exception e) { 
        	// If an exception occurs, print the stack trace and return an error response
            e.printStackTrace();
            // Returning an error message with HTTP status 500 (Internal Server Error)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
