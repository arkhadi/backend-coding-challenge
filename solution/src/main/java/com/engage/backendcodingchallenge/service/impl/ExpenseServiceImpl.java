package com.engage.backendcodingchallenge.service.impl;

import com.engage.backendcodingchallenge.model.Expense;
import com.engage.backendcodingchallenge.repository.ExpenseRepository;
import com.engage.backendcodingchallenge.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense findExpenseById(Integer id) {
        return expenseRepository.findById(id);
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.saveAndFlush(expense);
    }
}
