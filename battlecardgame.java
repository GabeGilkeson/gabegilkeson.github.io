/*
Written by Gabriel Gilkeson
For Mr. Gross's Software Development class – Final Project

Description: Each player takes turns drawing cards and trying to guess a number to deal damage to the opponent.
The game includes keyboard input, saving and loading to a file, a Queue for turn order, and a Stack for discarded cards.
*/

import java.io.*;
import java.util.*;

public class battlecardgame {
    static Scanner scanner = new Scanner(System.in);
    //Maximum health for each player
    static final int MAX_HEALTH = 30;

    //Queue for keeping track of which players turn it is
    static Queue<String> turnQueue = new LinkedList<>();

    //Stack used to store discarded cards
    static Stack<Integer> discardPile = new Stack<>();

    //The deck of cards
    static ArrayList<Integer> deck = new ArrayList<>();

    //Player names and health
    static String player1, player2;
    static int hp1 = MAX_HEALTH, hp2 = MAX_HEALTH;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Gabe's Card Battle Game");
        System.out.print("Load previous game? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        //If user chooses to load, try loading game data
        if (choice.equals("yes") && loadGame()) {
            System.out.println("Game loaded successfully.");
        } else {
            startNewGame();
        }

        //Shuffle the deck before playing
        shuffleDeck();

        //Game loop
        while (hp1 > 0 && hp2 > 0) {
            playTurn();

            //Ask if player wants to save after each round
            if (askToSave()) {
                saveGame();
                System.out.println("Game saved.");
            }
        }

        //Print the winner
        String winner = hp1 > 0 ? player1 : player2;
        System.out.println(winner + " wins the game!");
        scanner.close();
    }

    //Set up a new game by getting names and setting health
    static void startNewGame() {
        System.out.print("Enter Player 1's name: ");
        player1 = scanner.nextLine();

        System.out.print("Enter Player 2's name: ");
        player2 = scanner.nextLine();

        hp1 = hp2 = MAX_HEALTH;

        //Add players to the turn queue
        turnQueue.clear();
        turnQueue.add(player1);
        turnQueue.add(player2);
    }

    //Create and shuffle a full deck of cards
    static void shuffleDeck() {
        deck.clear();
        for (int i = 2; i <= 14; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }
        Collections.shuffle(deck);
    }

    //Handle one players turn
    static void playTurn() {
        //If deck is empty reshuffle
        if (deck.isEmpty()) {
            shuffleDeck();
        }

        //Get current player and opponent
        String currentPlayer = turnQueue.poll();
        String opponent = currentPlayer.equals(player1) ? player2 : player1;

        int opponentHp = currentPlayer.equals(player1) ? hp2 : hp1;

        //Draw a card and add it to discard pile
        int card = deck.remove(0);
        discardPile.push(card);

        System.out.println("\n" + currentPlayer + "'s turn!");

        //Random number between 1 and 10 which is the target number
        int secretNumber = new Random().nextInt(10) + 1;

        System.out.print("Guess a number between 1 and 10 to attack: ");
        int guess = getValidNumber();

        //The closer the guess the higher the damage
        int difference = Math.abs(secretNumber - guess);
        int damage = Math.max(1, 10 - difference); //Minimum 1 damage

        System.out.println("You guessed " + guess + ". Secret number was " + secretNumber + ".");
        System.out.println("You dealt " + damage + " damage!");

        //Apply damage to opponent
        if (opponent.equals(player1)) {
            hp1 -= damage;
        } else {
            hp2 -= damage;
        }

        //Show both players health
        System.out.println(player1 + " HP: " + Math.max(hp1, 0));
        System.out.println(player2 + " HP: " + Math.max(hp2, 0));

        //Add player back to the end of the queue
        turnQueue.add(currentPlayer);
    }

    //Get a valid number between 1 and 10 from the player
    static int getValidNumber() {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if (num >= 1 && num <= 10) return num;
            } catch (Exception e) {
                //Just catch and continue
            }
            System.out.print("Invalid input. Enter a number between 1 and 10: ");
        }
    }

    //Ask player if they want to save the game
    static boolean askToSave() {
        System.out.print("Would you like to save the game? (yes/no): ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    //Save game data to a file
    static void saveGame() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("savegame.txt"));
        writer.println(player1);
        writer.println(player2);
        writer.println(hp1);
        writer.println(hp2);
        writer.println(turnQueue.peek()); //Save whos next
        writer.close();
    }

    //Load game data from a file
    static boolean loadGame() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("savegame.txt"));
            player1 = reader.readLine();
            player2 = reader.readLine();
            hp1 = Integer.parseInt(reader.readLine());
            hp2 = Integer.parseInt(reader.readLine());
            String nextTurn = reader.readLine();
            reader.close();

            //Set turn order based on saved data
            turnQueue.clear();
            if (nextTurn.equals(player1)) {
                turnQueue.add(player1);
                turnQueue.add(player2);
            } else {
                turnQueue.add(player2);
                turnQueue.add(player1);
            }
            return true;
        } catch (Exception e) {
            System.out.println("No saved game found or error loading file.");
            return false;
        }
    }

    //Turn a card number into a readable name
    static String cardName(int value) {
        switch (value) {
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return String.valueOf(value);
        }
    }
}