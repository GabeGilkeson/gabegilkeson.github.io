package Horse;

public class Horse {
    String name; // Current name of the horse
    int birthYear; // Year the horse was born
    String[] names = new String[10]; // Array of old names of the horse
    int numberOfNames = 0; // How many old names are there

    public Horse(String horseName, int year) { // Horse constructor
        name = horseName; // Assigns the name
        birthYear = year; // Assigns the year
    }

    public void age(int currentYear) { // Keep as void
        int horseAge = currentYear - birthYear; // Calculate the age
        System.out.println(name + " is " + horseAge + " years old."); // Print the age
    }

    public void changeName(String newName) {
        if (numberOfNames < names.length) {
            names[numberOfNames] = name; // Save the old name
            numberOfNames++;
        }
        name = newName; // Update the instance variable
    }

    public String toString() {
        return name; // Returns the current name
    }
}