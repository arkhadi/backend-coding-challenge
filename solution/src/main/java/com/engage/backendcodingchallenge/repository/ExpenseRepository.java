package com.engage.backendcodingchallenge.repository;

import com.engage.backendcodingchallenge.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, String> {

    Expense findById(Integer id);
}
