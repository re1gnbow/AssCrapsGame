import java.util.Random;
import java.util.Scanner;
class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        while (playAgain) {
            int firstRoll = rollDice(random);
            System.out.println("First roll: " + firstRoll);
            if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
                System.out.println("You crapped out! You lose.");
            } else if (firstRoll == 7 || firstRoll == 11) {
                System.out.println("You rolled a natural! You win.");
            } else {
                int point = firstRoll;
                System.out.println("The point is now set to: " + point);
                boolean keepRolling = true;
                while (keepRolling) {
                    int newRoll = rollDice(random);
                    System.out.println("Rolling again: " + newRoll);
                    if (newRoll == point) {
                        System.out.println("You made the point! You win.");
                        keepRolling = false;
                    } else if (newRoll == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        keepRolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        System.out.println("Thank you for playing Craps!");
        scanner.close();
    }
    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);
        return sum;
    }
}