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