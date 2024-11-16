/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program creates a Car class that keeps track of a car's make, model, 
manufacture year, and allows the car to change its model while keeping track of all previous models.
*/

package Car;

import java.util.ArrayList;

public class Car {
    String make;
    String model;
    int year;
    ArrayList<String> modelHistory = new ArrayList<String>(); // keeps a record of all previous models
    int numberOfModels = 0;

    // Constructor to initialize car object with make, model, and year
    public Car(String carMake, String carModel, int carYear) {
        make = carMake;
        model = carModel;
        year = carYear;
    }

    // Method to change the car's model and store the old model in history
    public void changeModel(String newModel) {
        if (numberOfModels < modelHistory.size()) {
            modelHistory.add(model); // add current model to history
            numberOfModels++;
        }
        model = newModel; // change to the new model
    }

    // Method to print car details
    public void carDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Year of Manufacture: " + year);
    }

    // String representation of the car object
    public String toString() {
        return make + " " + model + " (" + year + ")";
    }
}