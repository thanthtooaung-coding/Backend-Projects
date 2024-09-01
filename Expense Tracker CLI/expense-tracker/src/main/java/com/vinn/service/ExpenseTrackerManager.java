package com.vinn.service;

import java.io.IOException;

public interface ExpenseTrackerManager {
    void addExpense() throws IOException;
    void updateExpense() throws IOException;
    void deleteExpense() throws IOException;
    void listExpenses() throws IOException;
    void viewSummary() throws IOException;
}
