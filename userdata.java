/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program collects user data, saves it to a file, 
reads the file, and averages the ages from the user data.
*/

import java.io.*;
import java.util.*;

public class userdata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "userdata.txt";

        List<String> users = new ArrayList<>();

        // Get input from 5 users
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter details for User " + i + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            double age;
            while (true) {
                System.out.print("Age: ");
                String ageInput = scanner.nextLine();
                try {
                    age = Double.parseDouble(ageInput);
                    if (age <= 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    // Invalid number or negative input
                    System.out.println("Invalid age! Please enter a positive number.");
                }
            }

            System.out.print("Favorite Color: ");
            String color = scanner.nextLine();

            System.out.print("City: ");
            String city = scanner.nextLine();

            System.out.print("Pet Name: ");
            String pet = scanner.nextLine();

            // Store user info in one string
            String userData = name + " - " + age + " - " + color + " - " + city + " - " + pet;
            users.add(userData);
        }

        // Write data to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String user : users) {
                writer.write(user);
                writer.newLine();
            }
            System.out.println("\nData saved successfully to " + filename);
        } catch (IOException e) {
            // If there's a problem saving the file
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read and display data from file
        System.out.println("\nUser Data from File:");
        List<Double> agesFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

                // Get the age from each line
                String[] parts = line.split(" - ");
                if (parts.length >= 2) {
                    try {
                        double ageFromFile = Double.parseDouble(parts[1]);
                        agesFromFile.add(ageFromFile);
                    } 
                    // Skip if age is messed up
                    catch (NumberFormatException ignored) {
                    }
                }

            }
        } catch (IOException e) {
            // If there's a problem reading the file
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Calculate average age from the file
        double averageAge = agesFromFile.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.printf("\nThe average age of users is: %.2f years\n", averageAge);
    }
}
