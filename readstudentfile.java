/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program reads the student data from the file "student.txt" 
and prints each line to the console.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readstudentfile {
    public static void main(String[] args) {
        // Try to open the file
        try {
            // Create a File object to refer to the "student.txt" file
            File file = new File("student.txt");
            
            // Create a Scanner object to read from the file
            Scanner fileScanner = new Scanner(file);
            
            // Read and print the first line (name)
            if (fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine(); // Read a line of text
                System.out.println("Name: " + name);
            }
            
            // Read and print the second line (year)
            if (fileScanner.hasNextLine()) {
                String year = fileScanner.nextLine(); // Read a line of text
                System.out.println("Year: " + year);
            }
            
            // Read and print the third line (school name)
            if (fileScanner.hasNextLine()) {
                String school = fileScanner.nextLine(); // Read a line of text
                System.out.println("School: " + school);
            }
            
            // Close the scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("The file 'student.txt' was not found.");
        }
    }
}
