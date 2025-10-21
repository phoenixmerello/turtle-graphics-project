package week3;

import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a sentence: ");
        String sentence = scan.nextLine().strip();

        String[] words = sentence.split(" ");
        StringBuilder r = new StringBuilder();

        for (String string : words) {
            StringBuilder x = new StringBuilder(string);
            r.append(x.reverse()).append(" ");

        }

        System.out.println(r.toString());
   }
}


