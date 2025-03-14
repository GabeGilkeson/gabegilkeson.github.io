/* 
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program takes a hard-coded string, breaks it into individual words, and prints each word on a separate line.
It also asks the user for input, breaks that input into words, and counts the number of words.
*/

import java.util.Scanner;

public class stringmanipulation {
    public static void main(String[] args) {
        
        // Hard coded string
        String testString = "the quick Brown Fox Jumped over the lazy dog";
        
        // Breaking the hard coded string into words and printing each one on a new line
        String[] words = testString.split(" ");
        System.out.println("Words from the hard-coded string:");
        for (String word : words) {
            System.out.println(word);
        }
        
        // Print the count of words in the hard coded string
        System.out.println("Total number of words: " + words.length);
        
        // Create a Scanner object to get user input
        Scanner inputScanner = new Scanner(System.in);
        
        // Ask the user for a line of text
        System.out.print("Please enter a line of text: ");
        String userInput = inputScanner.nextLine();
        
        // Remove punctuation
        userInput = userInput.replaceAll("[,.]", "");
        
        // Split the user input into words
        String[] userWords = userInput.split(" ");
        
        // Print out each word from the user's input on a separate line
        System.out.println("Words from your input:");
        for (String word : userWords) {
            System.out.println(word);
        }
        
        // Print the count of words from the user's input
        System.out.println("Total number of words: " + userWords.length);
        
        // Close the scanner
        inputScanner.close();
    }
}
