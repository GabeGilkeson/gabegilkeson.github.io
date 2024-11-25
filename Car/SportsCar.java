/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program extends the Car class by creating a SportsCar class that adds 
the properties of horsepower and top speed.
*/

package Car;

public class SportsCar extends Car {
    int horsepower;
    int topSpeed;

    public SportsCar(String carMake, String carModel, int carYear, int carHorsepower, int carTopSpeed) {
        super(carMake, carModel, carYear);
        horsepower = carHorsepower;
        topSpeed = carTopSpeed;
    }

    public void carDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Year of Manufacture: " + year);
        System.out.println("Horsepower: " + horsepower + " hp");
        System.out.println("Top Speed: " + topSpeed + " mph");
    }
}
