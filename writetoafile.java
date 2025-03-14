/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program asks the user to input their name, year in school, and school name.
Then it writes this information to a file called student.txt, each item on its own line.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class writetoafile {
    public static void main(String[] args) {
        // Create a scanner object to read input from the keyboard
        Scanner inputScanner = new Scanner(System.in);

        // Ask for the user's first and last name
        System.out.print("Please enter your first and last name: ");
        String name = inputScanner.nextLine();

        // Ask for the user's year in school
        System.out.print("What year are you in (e.g., 9th, Freshman, etc.): ");
        String year = inputScanner.nextLine();

        // Ask for the user's school name
        System.out.print("What is the name of your school: ");
        String schoolName = inputScanner.nextLine();

        // Try to write the data to a file called student.txt
        try {
            // Create a FileWriter object to write to the file
            FileWriter writer = new FileWriter("student.txt");

            // Write the name, year, and school name to the file
            writer.write(name + "\n");
            writer.write(year + "\n");
            writer.write(schoolName + "\n");

            // Close the file after writing
            writer.close();

            // Let the user know their information has been saved
            System.out.println("Your information has been saved to student.txt.");

        } catch (IOException e) {
            // If there's an error, print a message
            System.out.println("An error occurred while writing to the file.");
        }

        // Close the scanner
        inputScanner.close();
    }
}
