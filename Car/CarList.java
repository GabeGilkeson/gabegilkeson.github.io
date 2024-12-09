/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program manages a list of Car objects, creates a few instances of cars,
and changes their model while displaying their details.
*/

package Car;

import java.util.ArrayList;
import java.util.Collections;

public class CarList {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();

        SportsCar sportsCar1 = new SportsCar("Ferrari", "488", 2020, 660, 211);
        Car car1 = new Car("Toyota", "Corolla", 2015);
        ElectricCar electricCar1 = new ElectricCar("Tesla", "Model 3", 2022, 75, 350);

        Car car2 = new Car("Honda", "Civic", 2017);
        SportsCar sportsCar2 = new SportsCar("Lamborghini", "Huracan", 2021, 640, 202);
        ElectricCar electricCar2 = new ElectricCar("Rivian", "R1T", 2023, 135, 314);
        
        Car car3 = new Car("Ford", "Fusion", 2018);
        SportsCar sportsCar3 = new SportsCar("Porsche", "911", 2019, 450, 190);
        ElectricCar electricCar3 = new ElectricCar("BMW", "i4", 2023, 80, 300);
        
        Car car4 = new Car("Chevrolet", "Malibu", 2016);
        SportsCar sportsCar4 = new SportsCar("McLaren", "720S", 2021, 710, 212);

        cars.add(car1);
        cars.add(sportsCar1);
        cars.add(electricCar1);
        cars.add(car2);
        cars.add(sportsCar2);
        cars.add(electricCar2);
        cars.add(car3);
        cars.add(sportsCar3);
        cars.add(electricCar3);
        cars.add(car4);
        cars.add(sportsCar4);

        System.out.println("Before sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }

        Collections.sort(cars);

        System.out.println("\nAfter sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}    