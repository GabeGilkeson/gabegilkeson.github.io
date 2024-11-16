/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program manages a list of Car objects, creates a few instances of cars,
and changes their model while displaying their details.
*/

package Car;

import java.util.ArrayList;

public class CarList {
    public static void main(String[] args) {
        // Create an ArrayList to store Car objects
        ArrayList<Car> cars = new ArrayList<Car>();

        // Create a few Car objects
        Car car1 = new Car("Toyota", "Corolla", 2015);
        Car car2 = new Car("Honda", "Civic", 2018);
        Car car3 = new Car("Ford", "Focus", 2020);

        // Add Car objects to the ArrayList
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // Display car details before model change
        for (Car car : cars) {
            car.carDetails();
        }

        // Change the model of one car
        car1.changeModel("Camry");

        // Display car details after model change
        System.out.println("\nAfter Changing Model:");
        for (Car car : cars) {
            car.carDetails();
        }
    }
}