/* 
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program lets the user add students to a stack and a queue.
The user can enter names, addresses, and IDs. 
It then prints out the queue and the stack.
Debugging was added using a boolean.
*/

import java.util.Scanner;

public class stackandqueuetest {
    public static void main(String[] args) {
        boolean debug = true; //Used to toggle debug on and off

        Scanner scanner = new Scanner(System.in);

        LinkedListTest queue = new LinkedListTest(); //For queue operations
        LinkedListTest stack = new LinkedListTest(); //For stack operations

        System.out.println("Enter student name, address, and ID to add to the stack and queue.");
        System.out.println("Type 'stop' as the name to end input.\n");

        //Keep asking for student until user types "stop"
        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("stop")) {
                if (debug) 
                    System.out.println("Debug: User typed 'stop' ending input loop."); 
                    //Important in order to check that the input loop ends correctly.
                break;
            }

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            if (debug) {
                System.out.println("Debug: Create StudentObject with values:");
                System.out.println("Debug: Name: " + name + ", Address: " + address + ", ID: " + id);
                //Important because this helps verify that the student data is being gathered correctly before being stored.
            }

            StudentObject student = new StudentObject(name, address, id);

            queue.enqueue(student); //Add to queue
            if (debug) 
                System.out.println("Debug: Added student to queue.");
                //Important to check that the student was added to the queue.

            stack.push(student);    //Add to stack
            if (debug) 
                System.out.println("Debug: Added student to stack.");
                //Important to confirm that the student was also added to the stack.
        }

        System.out.println("\nQueue (First In, First Out):"); //Print queue
        while (!queue.isEmpty()) {
            StudentObject student = queue.dequeue();
            if (debug) 
                System.out.println("Debug: Removed student from queue."); 
                //Important to make sure dequeue is working and items are removed in the correct order.
            System.out.println(student);
        }

        System.out.println("\nStack (Last In, First Out):");
        while (!stack.isEmpty()) {
            StudentObject student = stack.pop(); //Print stack
            if (debug) 
                System.out.println("Debug: Removed student from stack.");
                //Important to see if stack behavior is working.
            System.out.println(student);
        }

        if (debug) 
            System.out.println("Debug: Program finished running."); 
            //Important to confirm the whole process completed without error.

        scanner.close();
    }
}
