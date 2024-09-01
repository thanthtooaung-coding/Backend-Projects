import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        boolean playAgain;

        do {
            int maxAttempts = getDifficultyLevel();
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " chances to guess the correct number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Incorrect! The number is greater than " + userGuess + ".");
                } else {
                    System.out.println("Incorrect! The number is less than " + userGuess + ".");
                }
            }

            if (hasGuessedCorrectly) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            } else {
                System.out.println("Sorry, you've run out of chances. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    private static int getDifficultyLevel() {
        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Great! You have selected the Easy difficulty level.");
                return 10;
            case 2:
                System.out.println("Great! You have selected the Medium difficulty level.");
                return 5;
            case 3:
                System.out.println("Great! You have selected the Hard difficulty level.");
                return 3;
            default:
                System.out.println("Invalid choice. Defaulting to Medium difficulty.");
                return 5;
        }
    }
}
