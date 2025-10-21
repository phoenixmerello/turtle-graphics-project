package week3;

import java.util.Scanner;

public class Punctuation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Mary had a little lamb, her fleece was as white as snow, and everywhere Mary went, the lamb was sure to go. -that was a nice poem- the end.");
        String sentence = ("Mary had a little lamb, her fleece was as white as snow, and everywhere Mary went, the lamb was sure to go. -that was a nice poem- the end.");

        int periodcount = 0;
        int commacount = 0;
        int coloncount = 0;
        int dashcount = 0;
        int quotationcount = 0;
        int exclamationcount = 0;
        int questioncount = 0;
        int semicoloncount = 0;
        int total = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '.') {
                periodcount++;
                total++;
            }
            if (sentence.charAt(i) == ',') {
                commacount++;
                total++;
            }
            if (sentence.charAt(i) == '-') {
                dashcount++;
                total++;
            }
            if (sentence.charAt(i) == ':') {
                coloncount++;
                total++;
            }

            if (sentence.charAt(i) == '"') {
                quotationcount++;
                total++;
            }

            if (sentence.charAt(i) == '!') {
                exclamationcount++;
                total++;
            }

            if (sentence.charAt(i) == '?') {
                questioncount++;
                total++;
            }
            if (sentence.charAt(i) == ';') {
                semicoloncount++;
                total++;
            }

        }
        System.out.println();
        System.out.println("////TABLE\\\\\\\\");
        System.out.println();
        System.out.println("There are " + periodcount + " periods in the sentence");
        System.out.println("There are " + commacount + " commas in the sentence");
        System.out.println("There are " + dashcount + " dashes in the sentence");
        System.out.println("There are " + coloncount + " colons in the sentence");
        System.out.println("There are " + quotationcount + " quotation marks in the sentence");
        System.out.println("There are " + exclamationcount + " exclamation marks in the sentence");
        System.out.println("There are " + questioncount + " question marks in the sentence");
        System.out.println("There are " + semicoloncount + " semicolons in the sentence");
        System.out.println("There are " + total + " punctuations in the sentence");

    }
}
