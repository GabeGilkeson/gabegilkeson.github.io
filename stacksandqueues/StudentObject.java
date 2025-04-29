/* 
Modified by Gabe Gilkeson
For Mr. Gross's Software Development class
Borrowed from Mr. Gross's GitHub. https://github.com/kimgrossteacher/linkedlist

Description: This class represents a student with a name, address, and student ID.
It contains methods to retrieve and modify student information, for name, address, and ID.
*/
import java.util.Scanner;

public class StudentObject {

    private String name;
    private String address;
    private String studentID;

    //Constructor to initialize the student's data.
    StudentObject(String name, String address, String studentID) {
        this.name = name;
        this.address = address;
        this.studentID = studentID;
    }

    //Returns a string representation of the student object.
    public String toString() {
        return name + " at " + address + " student ID " + studentID;
    }

    //Getter and setter methods for the student's name, address, and ID.
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getID() {
        return studentID;
    }

    //Methods to change the student's name, address, and ID.
    public void changeName(String newName) {
        name = newName;
    }

    public void changeAddress(String newAddress) {
        address = newAddress;
    }

    public void changeID(String newID) {
        System.out.println("Student ID's should not be changed. Are you sure this needs changing?");
        @SuppressWarnings("resource")
        Scanner inp = new Scanner(System.in);
        String test = inp.nextLine();
        if (test.equals("y") || test.equals("Y")) {
            studentID = newID;
        }
    }
}
