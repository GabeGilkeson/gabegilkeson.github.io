/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program creates a Car class that keeps track of a car's make, model, 
year, and allows the changing of its model while saving the history of all previous models. 
It also implements the Comparable interface to sort cars by their year of manufacture.
*/

package Car;

import java.util.ArrayList;

public class Car implements Comparable<Car> {
    String make;
    String model;
    int year;
    ArrayList<String> modelHistory = new ArrayList<String>();
    int numberOfModels = 0;

    public Car(String carMake, String carModel, int carYear) {
        make = carMake;
        model = carModel;
        year = carYear;
    }

    public void changeModel(String newModel) {
        modelHistory.add(model);
        model = newModel;
        numberOfModels++;
    }

    public void carDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Year of Manufacture: " + year);
    }

    public int compareTo(Car other) {
        return Integer.compare(this.year, other.year);
    }

    public String toString() {
        return make + " " + model + " (" + year + ")";
    }
}