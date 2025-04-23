import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] options = {"Rock", "Paper", "Scissors"};
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Choose Rock, Paper, or Scissors: ");
        String playerChoice = scanner.nextLine();

        int computerIndex = rand.nextInt(3); // 0, 1, or 2
        String computerChoice = options[computerIndex];

        System.out.println("Computer chose: " + computerChoice);

        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (
            (playerChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
            (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
            (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))
        ) {
            System.out.println("🎉 You win!");
        } else {
            System.out.println("😢 You lose.");
        }

        scanner.close();
    }
}