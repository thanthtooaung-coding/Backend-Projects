# Number Guessing Game

Number Guessing Game is a simple command-line application where you try to guess a randomly selected number within a specified number of attempts based on your chosen difficulty level. This application is designed for users who enjoy interactive console games.

## Features

- **Random Number Generation**: The computer selects a random number between 1 and 100.
- **Difficulty Levels**: Choose from three difficulty levels which determine the number of attempts you get:
    - **Easy**: 10 chances
    - **Medium**: 5 chances
    - **Hard**: 3 chances
- **User Feedback**: Receive hints indicating whether the correct number is higher or lower than your guess.
- **Replay Option**: Play multiple rounds of the game and try to guess the number again if you wish.

## How to Play

### Run the Application

1. Compile and run the `NumberGuessingGame` class.
2. The game will start and prompt you to select a difficulty level.

### Select Difficulty Level

- Enter the number corresponding to the difficulty level you want:
    - `1` for Easy
    - `2` for Medium
    - `3` for Hard

### Guess the Number

1. Enter your guess when prompted.
2. The game will provide feedback on whether your guess is too high or too low.
3. Continue guessing until you either guess the correct number or run out of chances.

### Winning or Losing

- If you guess the number correctly within the allowed attempts, you win!
- If you exhaust all attempts without guessing correctly, the game will reveal the correct number.

### Play Again

- After each game, you will be asked if you want to play again. Enter `yes` to play another round or `no` to quit.

## Error Handling

- **Invalid Input**: The game handles invalid inputs gracefully, asking the user to enter a valid number or difficulty choice.
- **Out of Attempts**: If the user runs out of attempts, the game will display the correct number and end the round.

## Requirements

- Java 11 or higher

## Installation

### Clone the Repository

```bash
git clone https://github.com/thanthtooaung-coding/Backend-Projects
```

### Navigate to the project directory:
```bash
cd Backend-Projects/Number Guessing Game
```

### Compile and run the application:
```bash
javac .\NumberGuessingGame.java
java NumberGuessingGame
```

## License
This project is licensed under the [MIT License](../LICENSE).