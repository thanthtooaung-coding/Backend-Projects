# Task Tracker CLI

Task Tracker CLI is a simple command-line application for managing tasks. It allows users to add, update, delete, list tasks, and change their status. This application is designed for those who prefer managing tasks via the command line.

## Features
- **Add Task**: Create a new task with a description.
- **Update Task**: Modify the description of an existing task.
- **Delete Task**: Remove a task by its ID.
- **List Tasks**: Display tasks based on their status (e.g., "todo", "in-progress", "done").
- **Mark Task as In Progress**: Change the status of a task to "in-progress".
- **Mark Task as Done**: Change the status of a task to "done".
- **Exit**: Exit the application.

## How to Use

### Run the Application:
1. Compile and run the `TaskTrackerApp` class.
2. The application will display a menu with options.

### Choose an Option:
- Enter the number corresponding to the action you want to perform.

### Add a Task:
1. Select the "Add Task" option by entering `1`.
2. Enter the task description when prompted.
3. The task will be added with an initial status of "todo".

### Update a Task:
1. Select the "Update Task" option by entering `2`.
2. Enter the ID of the task you want to update.
3. If the task exists, enter the new description when prompted.

### Delete a Task:
1. Select the "Delete Task" option by entering `3`.
2. Enter the ID of the task you want to delete.
3. If the task exists, it will be removed.

### List Tasks:
1. Select the "List Tasks" option by entering `4`.
2. Enter the status of the tasks you want to view (e.g., "todo", "in-progress", "done").
3. If you leave the input empty, all tasks will be listed.

### Mark Task as In Progress:
1. Select the "Mark in Progress" option by entering `5`.
2. Enter the ID of the task you want to mark as "in-progress".

### Mark Task as Done:
1. Select the "Mark as Done" option by entering `6`.
2. Enter the ID of the task you want to mark as "done".

### Exit the Application:
1. Select the "Exit" option by entering `7`.

## Error Handling
- **Invalid Input**: The application handles invalid inputs gracefully, asking the user to enter a valid number or task ID.
- **Task Not Found**: If a task ID does not exist, the application will notify the user.

## Requirements
- Java 11 or higher
- Jackson's library for JSON processing

## Installation

### Clone the repository:
```bash
git clone https://github.com/thanthtooaung-coding/Backend-Projects
```

### Navigate to the project directory:
```bash
cd Backend-Projects/Task Tracker CLI
```

### Compile and run the application:
```bash
javac -d bin src/com/vinn/*.java
java -cp bin com.vinn.TaskTrackerApp
```

## License
This project is licensed under the [MIT License](../LICENSE).