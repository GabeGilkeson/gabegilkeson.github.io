/*
Modified by Gabe Gilkeson
For Mr. Gross's Software Development class
Original file created by Kimg@techtrepacademy.com for debugging assignment

Description: This program uses loops to print numbers and checks if i equals 0. 
It had a lot of errors like wrong capitalization, print mistakes, and code being outside of the main method.
These were all fixed.
*/

package errors;

public class error {
    public static void main(String[] args) {
        
        //Declare "i"
        int i;

        //Prints out two lines
        System.out.println("Hello everybody");
        System.out.println("Am I doing this correctly");

        //First loop prints numbers from 0 to 9
        for (i = 0; i < 10; i++) {
            System.out.println("the number i is " + i);
        }

        //Second loop counts from 10 to 1
        for ( i = 10; i > 0; i--) {
            System.out.println("the new number i is " + i);
        }

        //Check if i is 0 and print a message
        if (i == 0) {
            System.out.print("i is equal to zero\n");
        } else {
            System.out.print("i is not equal to zero\n");
        }
    }
    //what other errors can I put into a source code file?
}