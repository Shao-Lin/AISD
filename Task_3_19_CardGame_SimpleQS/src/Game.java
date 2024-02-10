import java.util.*;

import static java.util.Collections.shuffle;

public class Game {
    public static void main(String[] args) throws Exception {
        MyQueue<Card> deck = new MyQueue();
        MyStack<Card> table = new MyStack();
        int movies = 0;

        String[] values = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = new String[]{"Hearts", "Spades", "Diamonds", "Clubs"};
        for (String value : values) {
            for (String suit : suits) {
                deck.add(new Card(suit, value));
            }
        }
        deck.shuffleQ(deck);
        table.push(deck.pool());
        movies++;
        int counter = 0;
        while (counter != deck.count()) {
            movies++;
            if (!deck.peek().equals(table.peek())) {
                deck.add(deck.pool());
                counter++;
            } else {
                table.push(deck.pool());
                counter = 0;
            }
        }


        System.out.println("Количество ходов:" + " " + movies);
        System.out.println("-----------------------------------------------");
        System.out.println("Карты на столе:");
        while (!table.empty()){
            System.out.println(table.pop());
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Карты в колоде:");
        while (!deck.empty()){
            System.out.println(deck.pool());
        }
    }
}