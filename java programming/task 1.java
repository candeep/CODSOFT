import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain;
        int score = 0;

        do {
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 5;
            int attempts = 0;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thanks for playing! Your final score is " + score + ".");
    }
}
