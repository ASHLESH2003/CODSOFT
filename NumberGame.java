import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 7; // You can change this to adjust the number of attempts allowed
        int score = 0;

        System.out.println("Welcome to Guess the Number!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            System.out.println("\nI have selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");

            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempt(s).");
                    score++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempts >= attemptsLimit) {
                    System.out.println("You've reached the maximum number of attempts. The correct number was: " + targetNumber);
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("Thank you for playing Guess the Number!");
        System.out.println("Your final score is: " + score);
        scanner.close();
    }
}
