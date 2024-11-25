/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program extends the Car class by creating a ElectricCar class that adds 
the properties of battery capacity and range per charge.
*/

package Car;

public class ElectricCar extends Car {
    int batteryCapacity;
    int rangePerCharge;

    public ElectricCar(String carMake, String carModel, int carYear, int carBatteryCapacity, int carRangePerCharge) {
        super(carMake, carModel, carYear);
        batteryCapacity = carBatteryCapacity;
        rangePerCharge = carRangePerCharge;
    }

    public void carDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Year of Manufacture: " + year);
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Range Per Charge: " + rangePerCharge + " miles");
    }
}