/* 
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This is a two player card game where each player draws a card from a shuffled deck.
The cards are compared, and the player with the higher card wins the game.
Player 1 and Player 2 are prompted to enter their names before the game starts.
The program uses an ArrayList to store and manage the deck of cards, and the deck is shuffled randomly to simulate random card draws.
*/

import java.util.*;

public class cardgame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Get player names
        System.out.print("Enter Player 1's name: ");
        String player1 = scanner.nextLine();

        System.out.print("Enter Player 2's name: ");
        String player2 = scanner.nextLine();

        //Create a 52 card deck
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 2; i <= 14; i++) { // 2-10, Jack(11), Queen(12), King(13), Ace(14)
            for (int j = 0; j < 4; j++) { // 4 suits
                deck.add(i);
            }
        }

        //Shuffle the deck
        Collections.shuffle(deck);

        //Play game
        System.out.println("\nStarting the game.");

        //Player 1 draws
        System.out.println(player1 + ", press Enter to draw your card.");
        scanner.nextLine();
        int card1 = deck.remove(0);
        System.out.println(player1 + " drew: " + cardName(card1));

        //Player 2 draws
        System.out.println(player2 + ", press Enter to draw your card.");
        scanner.nextLine();
        int card2 = deck.remove(0);
        System.out.println(player2 + " drew: " + cardName(card2));

        //Compare cards
        if (card1 > card2) {
            System.out.println(player1 + " wins the game!\n");
        } else if (card2 > card1) {
            System.out.println(player2 + " wins the game!\n");
        } else {
            System.out.println("It's a tie!\n");
        }

        //Game over message
        System.out.println("The game has ended.");
        scanner.close();
    }

    //Converting card values to names
    public static String cardName(int value) {
        switch (value) {
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return String.valueOf(value);
        }
    }
}
