/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This version expands the card game I wrote into a turn-based battle game.
Each player has health, takes turns, and plays attack cards.
Used queue for player turns and stack to track played cards.
*/

import java.util.*;

public class battlecardgame {

    static class Player {
        String name;
        int health;

        Player(String name) {
            this.name = name;
            this.health = 30; //Starting health
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Get player names
        System.out.print("Enter Player 1's name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String name2 = scanner.nextLine();

        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        //Queue for turn order
        Queue<Player> turnQueue = new LinkedList<>();
        turnQueue.add(player1);
        turnQueue.add(player2);

        //Stack to keep track of cards played
        Stack<Integer> playedCards = new Stack<>();

        //Create and shuffle deck
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 2; i <= 14; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);

        System.out.println("\nBattle Start! Each player starts with 30 health.\n");

        //Game loop
        while (player1.health > 0 && player2.health > 0 && !deck.isEmpty()) {
            Player current = turnQueue.poll();
            Player opponent = (current == player1) ? player2 : player1;

            System.out.println(current.name + "'s turn. Press Enter to draw an attack card.");
            scanner.nextLine();

            int card = deck.remove(0);
            playedCards.push(card);

            int damage = card;
            opponent.health -= damage;

            System.out.println(current.name + " played: " + cardName(card));
            System.out.println(opponent.name + " took " + damage + " damage. Health now: " + Math.max(opponent.health, 0));
            System.out.println();

            //Add current player back to the queue
            turnQueue.add(current);
        }

        //Determine winner
        if (player1.health <= 0 && player2.health <= 0) {
            System.out.println("It's a tie! Both players are knocked out.");
        } else if (player1.health <= 0) {
            System.out.println(player2.name + " wins the battle!");
        } else if (player2.health <= 0) {
            System.out.println(player1.name + " wins the battle!");
        } else {
            System.out.println("Deck is empty. It's a draw!");
        }

        //Show all cards played
        System.out.println("\nCards played (most recent on top):");
        while (!playedCards.isEmpty()) {
            System.out.println(cardName(playedCards.pop()));
        }

        scanner.close();
    }

    public static String cardName(int value) {
        switch (value) {
            case 11: return "Jack (11)";
            case 12: return "Queen (12)";
            case 13: return "King (13)";
            case 14: return "Ace (14)";
            default: return String.valueOf(value);
        }
    }
}
