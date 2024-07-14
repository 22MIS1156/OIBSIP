import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1; // generate a random number between 1 and 100
        int attempts = 0;
        int maxAttempts = 5; // limit the number of attempts
        int score = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == secretNumber) {
                System.out.println(" Congratulations! You guessed it!");
                score = maxAttempts - attempts + 1; // calculate score based on attempts
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Your guess is too low. Try again!");
            } else {
                System.out.println("Your guess is too high. Try again!");
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you didn't guess it. The number was " + secretNumber);
        }

        System.out.println("Your score is " + score + " out of " + maxAttempts);
    }
}