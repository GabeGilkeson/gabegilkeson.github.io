/* 
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program lets the user add students to a stack and a queue.
The user can enter names, addresses, and IDs. 
It then prints out the queue and the stack.
*/

import java.util.Scanner;

public class stackandqueuetest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListTest queue = new LinkedListTest(); //For queue operations
        LinkedListTest stack = new LinkedListTest(); //For stack operations

        System.out.println("Enter student name, address, and ID to add to the stack and queue.");
        System.out.println("Type 'stop' as the name to end input.\n");

        //Keep asking for students until user types "stop"
        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("stop")) break;

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            StudentObject student = new StudentObject(name, address, id);
            queue.addNode(student);  //Add to queue
            stack.addNode(student);  //Add to stack
        }

        System.out.println("\nQueue:");
        queue.printFromFront(); //Print queue

        System.out.println("\nStack:");
        stack.printFromBack(); //Print stack

        scanner.close();
    }
}
