package week3;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Rock Paper Scissors Game");
        System.out.println();

        System.out.println("Enter rock, paper or scissors: ");
        String user = scan.nextLine();
        user = user.toLowerCase();

        String[] list = {"rock", "paper", "scissors"};
        Random rand  = new Random();
        int computer = rand.nextInt(list.length);


        if (list[computer].equals(user)) {
            System.out.println("It's a tie!");
        }
        else if (user.equals("rock")) {
            if (list[computer].equals("scissors")) {
                System.out.println("rock crushes scissors. You Win!");
            }
            else{
                System.out.println("rock crushes scissors. You Lose!");
            }

        }
        else if (user.equals("paper")) {
            if (list[computer].equals("rock")) {
                System.out.println("paper swallows rock. You Win!");
            }
            else{
                System.out.println("paper swallows rock. You Lose!");
            }

        }
        else if (user.equals("scissors")) {
            if (list[computer].equals("paper")) {
                System.out.println("scissors cuts paper. You Win!");
            }
            else{
                System.out.println("scissors cuts paper. You Lose!");
            }

        }


    }
}
