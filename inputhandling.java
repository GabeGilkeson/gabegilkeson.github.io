/* 
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program asks the user for an integer, a float, and a line of text.
It also tries to get the user's first and last name and greets them.
It handles errors if the user inputs the wrong type of data.
*/

import java.util.Scanner;

public class inputhandling {
    public static void main(String[] args) {
        // Create a Scanner object to read from the keyboard
        Scanner inputScanner = new Scanner(System.in);
        
        // Ask the user for an integer
        System.out.print("Please enter an integer: ");
        try {
            int userInt = inputScanner.nextInt(); // Reads an int value from the user
            System.out.println("Thank you for inputting the int, I read " + userInt);
        } catch (Exception e) {
            System.out.println("That was not a valid integer.");
            inputScanner.next(); // Clear invalid input
        }
        
        // Ask the user for a float
        System.out.print("Please enter a float: ");
        try {
            float userFloat = inputScanner.nextFloat(); // Reads a float value from the user
            System.out.println("Thank you for inputting the float, I read " + userFloat);
        } catch (Exception e) {
            System.out.println("That was not a valid float.");
            inputScanner.next(); // Clear invalid input
        }
        
        inputScanner.nextLine(); // Consume the newline left-over

        // Ask the user for a line of text
        System.out.print("Please enter a line of text: ");
        String line = inputScanner.nextLine(); // Reads a String value from the user
        System.out.println("Thank you for inputting the text, I read '" + line + "'");
        
        // Ask for full name and try to split it into first and last
        System.out.print("Please enter your full name (first and last): ");
        String fullName = inputScanner.nextLine(); // Reads the full name from the user
        String[] nameParts = fullName.split(" ");
        
        // If user entered both first and last name, print a greeting
        if (nameParts.length >= 2) {
            String firstName = nameParts[0];
            String lastName = nameParts[nameParts.length - 1];
            System.out.println("Hello, Mr./Ms. " + lastName + ", or can I call you " + firstName + "?");
        } else {
            System.out.println("It looks like you didn't enter a full name.");
        }
        
        inputScanner.close(); // Close the scanner
    }
}
