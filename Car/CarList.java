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
        ArrayList<Car> cars = new ArrayList<Car>();

        Car car1 = new Car("Toyota", "Corolla", 2015);
        SportsCar sportsCar1 = new SportsCar("Ferrari", "488", 2020, 660, 211);
        ElectricCar electricCar1 = new ElectricCar("Tesla", "Model 3", 2022, 75, 350);

        cars.add(car1);
        cars.add(sportsCar1);
        cars.add(electricCar1);

        System.out.println("Regular Car Details:");
        car1.carDetails();
        System.out.println();

        System.out.println("Sports Car Details:");
        sportsCar1.carDetails();
        System.out.println();

        System.out.println("Electric Car Details:");
        electricCar1.carDetails();
        System.out.println();

        car1.changeModel("Camry");

        System.out.println("After Changing Model:");
        System.out.println("Regular Car Details:");
        car1.carDetails();
        System.out.println();

        System.out.println("Sports Car Details:");
        sportsCar1.carDetails();
        System.out.println();

        System.out.println("Electric Car Details:");
        electricCar1.carDetails();
        
    }
}    