package week5;

import java.util.*;

public class Cards {
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] values = { "2", "3", "4", "5", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String value : values) {
                deck.add(value + " of " + suit);
            }
        }

        Collections.shuffle(deck);

        System.out.println("Your hand is:");
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.get(i));
        }
    }
}
