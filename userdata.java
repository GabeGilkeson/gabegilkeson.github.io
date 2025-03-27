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
        List<Integer> ages = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter details for User " + i + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            int age;
            while (true) {
                System.out.print("Age: ");
                String ageInput = scanner.nextLine();
                try {
                    age = Integer.parseInt(ageInput);
                    if (age <= 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age! Please enter a valid number.");
                }
            }

            System.out.print("Favorite Color: ");
            String color = scanner.nextLine();

            System.out.print("City: ");
            String city = scanner.nextLine();

            System.out.print("Pet Name: ");
            String pet = scanner.nextLine();

            String userData = name + " - " + age + " - " + color + " - " + city + " - " + pet;
            users.add(userData);
            ages.add(age);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String user : users) {
                writer.write(user);
                writer.newLine();
            }
            System.out.println("\nData saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("\nUser Data from File:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        double averageAge = ages.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.printf("\nThe average age of users is: %.2f years\n", averageAge);
    }
}