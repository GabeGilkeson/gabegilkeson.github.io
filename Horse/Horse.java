/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program creates a Horse class that keeps track of a horse's name, birth year,
allows the horse to change its name while saving old names, and calculates its age.
*/

package Horse;

import java.util.ArrayList;

public class Horse {
    String name; // current name of the horse
    int birthYear; //year the horse was born
    ArrayList<String> names = new ArrayList<String>(); //array of old names of the horse
    int numberOfNames = 0; //how many old names are there.

    public Horse(String horseName, int year) { //horse constructor needs its name and birth year.
        name = horseName; //assigns the name of the horse to the horseName which was sent in the construtor.
        birthYear = year; //assigns the year to the birthYear that was sent in the constructor;
    }

    public void age(int currentYear) {
        int horseAge = currentYear - birthYear;
        System.out.println(name + " is " + horseAge + " years old.");
    }

    public void changeName(String newName) { //change the name but save the old name
        if (numberOfNames < names.size()) {
            names.add(name); // Instead of using array indexing.
            numberOfNames++;
        }
        name = newName;
    }

    public String toString() {
        return name;
    }
}