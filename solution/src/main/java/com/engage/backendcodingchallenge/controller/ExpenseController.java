package com.engage.backendcodingchallenge.controller;

import com.engage.backendcodingchallenge.model.Expense;
import com.engage.backendcodingchallenge.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping(path = "/app/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExpenseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses(){
        LOGGER.info("Retrieving all the expenses");
        List<Expense> expenses = expenseService.findAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable("id") Integer id) {
        LOGGER.info("Retrieving expense with id: {}", id);
        Expense expense = expenseService.findExpenseById(id);
        LOGGER.info("Expense found: {}", expense);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense,
                                               UriComponentsBuilder ucBuilder) {
        LOGGER.info("Save expense: {}", expense);
        Expense savedExpense = expenseService.saveExpense(expense);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(savedExpense.getId()).toUri());
        LOGGER.info("Saved Expense: {}", savedExpense);
        return new ResponseEntity<>(savedExpense, headers, HttpStatus.CREATED);
    }

}
