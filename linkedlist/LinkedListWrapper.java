/* 
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program creates a linked list of student objects. 
It prompts the user to enter at least 5 students names, addresses, and IDs, 
and then stores each student in a linked list. Afterward, it prints the list
from front to back and from back to front.
*/

import java.util.Scanner;

public class LinkedListWrapper {

    public static void main(String[] args) {
        //Create a scanner
        Scanner scanner = new Scanner(System.in);

        //Create a new LinkedListTest to store student nodes
        LinkedListTest studentList = new LinkedListTest();

        //Introduction message to explain what the program does
        System.out.println("This program creates a linked list of student objects.");
        System.out.println("You will be asked to enter at least 5 students with their name, address, and ID.");

        //Control variable to manage whether to continue asking for data
        boolean addMore = true;
        int count = 0;

        //Loop to ask for student data and add it to the linked list
        while (addMore || count < 5) {
            //Prompt the user for student details and read their input
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student address: ");
            String address = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            //Create a new student object with the collected data
            StudentObject student = new StudentObject(name, address, id);

            //Add the student object to the linked list
            studentList.addNode(student);
            count++;

            //Ask if the user wants to add another student once the 5th student is added
            if (count >= 5) {
                System.out.print("Do you want to add another student? (y/n): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("y")) {
                    addMore = false;  //Exit the loop if the user doesn't want to add more students
                }
            }
        }

        //Print the students from front to back
        System.out.println("\nPrinting students from front to back:");
        StudentObject student = studentList.getHead();  //Get the first student in the list
        System.out.println(student);
        while (studentList.hasNext()) {
            student = studentList.getNext();  //Move to the next student in the list
            System.out.println(student);
        }

        //Print the students from back to front
        System.out.println("\nPrinting students from back to front:");
        student = studentList.getTail();  //Get the last student in the list
        System.out.println(student);
        while (studentList.hasPrevious()) {
            student = studentList.getPrevious();  //Move to the previous student in the list
            System.out.println(student);
        }

        //Close the scanner
        scanner.close();
    }
}
