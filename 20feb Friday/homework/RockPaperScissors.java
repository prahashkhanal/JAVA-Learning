import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};

        while (true) {
            System.out.println("\nChoose: Rock, Paper, Scissors or Quit");
            String userChoice = sc.nextLine();

            if (userChoice.equalsIgnoreCase("Quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a Tie!");
            } else if (
                    (userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
                            (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper")) ||
                            (userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock"))
            ) {
                System.out.println("You Win!");
            } else {
                System.out.println("Computer Wins!");
            }
        }

        sc.close();
    }
}