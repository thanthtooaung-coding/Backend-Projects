# GitHub User Activity CLI

A simple command-line interface (CLI) tool to fetch and display recent activity of a GitHub user using the GitHub API.

## Features

- Fetches recent public activities of any GitHub user.
- Displays activities such as pushing commits, creating issues, starring repositories, and more.

## Prerequisites

- Java Development Kit (JDK) installed (version 8 or later).
- The `json` library (`json-20240303.jar`) included in the `libs` folder of the project.

## Installation

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/thanthtooaung-coding/Backend-Projects
    cd Backend-Projects/Github User Activity CLI
    ```

2. **Download the JSON Library**:

   Download `json-20240303.jar` and place it in the `libs` directory of your project.

## Usage

1. **Compile the Program**:

   Open a terminal in the project directory and run:

    ```bash
    javac -cp .;libs/json-20240303.jar src/GitHubUserActivityCLI.java
    ```

2. **Run the Program**:

   Run the program with the following command:

    ```bash
    java -cp .;libs/json-20240303.jar;src GitHubUserActivityCLI
    ```

3. **Enter the GitHub Username**:

   You will be prompted to enter a GitHub username. The program will fetch and display the recent activity of the specified user.

## Example Output

```plaintext
Enter the GitHub username: thanthtooaung-coding
Performed CreateEvent on thanthtooaung-coding/thanthtooaung-coding
Performed CreateEvent on thanthtooaung-coding/thanthtooaung-coding
Pushed 1 commits to thanthtooaung-coding/Vuejs-Learning
```

## License
This project is licensed under the [MIT License](../LICENSE).