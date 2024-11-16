/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program creates a Horse class that keeps track of a horse's name, birth year,
allows the horse to change its name while saving old names, and calculates its age.
*/

package Horse;

import java.util.ArrayList;

public class Horse {
    String name;
    int birthYear;
    ArrayList<String> names = new ArrayList<String>();
    int numberOfNames = 0;

    public Horse(String horseName, int year) {
        name = horseName;
        birthYear = year;
    }

    public void age(int currentYear) {
        int horseAge = currentYear - birthYear;
        System.out.println(name + " is " + horseAge + " years old.");
    }

    public void changeName(String newName) {
        if (numberOfNames < names.size()) {
            names.add(name);
            numberOfNames++;
        }
        name = newName;
    }

    public String toString() {
        return name;
    }
}