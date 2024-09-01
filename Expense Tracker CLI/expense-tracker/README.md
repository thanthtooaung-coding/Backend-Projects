# Expense Tracker

**Expense Tracker** is a command-line application written in Java that allows users to manage their daily expenses. The application supports adding, updating, deleting, and listing expenses, as well as viewing a summary of all expenses. The data is stored in a file, ensuring that all expenses are persisted between sessions.

## Features

- **Add Expense**: Add a new expense entry with a description, amount, and date.
- **Update Expense**: Update an existing expense by its ID.
- **Delete Expense**: Remove an expense entry by its ID.
- **List All Expenses**: Display a list of all expenses.
- **View Expense Summary**: Show the total sum of all expenses.
- **Exit**: Safely exit the program.

## How to Use

### Run the Application:

1. **Compile and run the `ExpenseTrackerApp` class:**

```bash
javac -d bin src/com/vinn/ExpenseTrackerApp.java
java -cp bin com.vinn.ExpenseTrackerApp
```

2. **The application will display a menu with options.**

### Choose an Option:

- Enter the number or command corresponding to the action you want to perform.

### Add Expense:

1. Select the "Add Expense" option by entering `1` or `add`.
2. Enter the expense details when prompted, such as description, amount, and date.

### Update Expense:

1. Select the "Update Expense" option by entering `2` or `update`.
2. Enter the ID of the expense you want to update.
3. Provide the new details for the selected expense.

### Delete Expense:

1. Select the "Delete Expense" option by entering `3` or `delete`.
2. Enter the ID of the expense you want to delete.

### List All Expenses:

1. Select the "List All Expenses" option by entering `4` or `list`.
2. All expenses will be displayed with their details.

### View Expense Summary:

1. Select the "View Expense Summary" option by entering `5` or `summary`.
2. The total sum of all expenses will be displayed.

### Exit:

1. Select the "Exit" option by entering `6` or `exit`.
2. The program will terminate safely.

## Error Handling

- **Invalid Input**: If an invalid option or command is entered, the application will prompt the user to enter a valid choice.
- **File Not Found**: If the file for storing expenses is missing, the application will create a new one.

## Requirements

- Java Development Kit (JDK) 8 or later.
- A terminal or command prompt to run the application.

## License

This project is licensed under the [MIT License](../../LICENSE).
