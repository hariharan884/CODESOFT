package CODESOFT;

import java.util.Random;
import java.util.Scanner;

public class Task {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int rounds = 0;

        // Game loop for multiple rounds
        while (true) {
            rounds++;
            System.out.println("\n--- Round " + rounds + " ---");
            
            // Step 1: Generate a random number between 1 and 100
            Random random = new Random();
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;  // Limit the number of attempts
            
            // Step 2: User guesses the number
            System.out.println("Guess the number between 1 and 100!");

            // Start the guessing process
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                // Step 3: Compare guess with the number
                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                    score += Math.max(0, maxAttempts - attempts + 1);  // Rewarding better guesses
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + targetNumber + ".");
            }
            
            // Step 6: Option to play another round
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        // Step 7: Display final score
        System.out.println("\nGame over! Your final score is " + score + ".");
        scanner.close();
    }
}
