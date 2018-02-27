package com.engage.backendcodingchallenge.service;

import com.engage.backendcodingchallenge.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> findAllExpenses();

    Expense findExpenseById(Integer id);

    Expense saveExpense(Expense expense);

}
