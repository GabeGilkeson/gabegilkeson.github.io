/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program manages a list of Horse objects, creates a few instances of horses,
and calculates their ages.
*/

package Horse;

import java.util.ArrayList;

public class HorseList {
    public static void main(String[] args) {
        ArrayList<Horse> objects = new ArrayList<Horse>();

        Horse horse1 = new Horse("Trigger", 2000);
        Horse horse2 = new Horse("Tonto", 2001);
        Horse horse3 = new Horse("Holler", 2002);

        objects.add(horse1);
        objects.add(horse2);
        objects.add(horse3);

        for (Horse horse : objects) {
            horse.age(2024);
        }
    }
}