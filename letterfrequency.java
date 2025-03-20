/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program reads the student data from the file "student.txt" 
and prints each line to the console.
*/

import java.io.*;
import java.util.*;

public class letterfrequency {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("letter_frequency.csv"));
            reader.readLine();

            int totalFrequency = 0;
            Map<String, Integer> letterCounts = new HashMap<>();
            Map<String, Double> letterPercentages = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.split(",").length < 2) {
                    continue;
                }

                String[] parts = line.split(",");
                String letter = parts[0].trim().replace("\"", "");
                int frequency = Integer.parseInt(parts[1].trim());

                letterCounts.put(letter, frequency);
            }

            for (int count : letterCounts.values()) {
                totalFrequency += count;
            }

            double totalPercentage = 0;
            for (String letter : letterCounts.keySet()) {
                double percentage = (letterCounts.get(letter) / (double) totalFrequency) * 100;
                letterPercentages.put(letter, percentage);
                totalPercentage += percentage;
            }

            System.out.println("Letter\tFrequency\tPercentage");
            for (String letter : letterCounts.keySet()) {
                int frequency = letterCounts.get(letter);
                double percentage = letterPercentages.get(letter);
                System.out.printf("%-6s\t%-10d\t%-6.2f%%\n", letter, frequency, percentage);
            }

            double averageFrequency = totalFrequency / (double) letterCounts.size();

            System.out.printf("Total\t%-10.2f\t%-6.2f%%\n", averageFrequency, 100.00);

            reader.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
