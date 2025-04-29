/*
Modified by Gabe Gilkeson
For Mr. Gross's Software Development class
Original file created by Kimg@techtrepacademy.com for debugging assignment

Description: This program prints the numbers 0 to 24 and says when i equals 1.
It had a wrong equals sign (= instead of ==) and now works correctly.
*/

package errors;

class HelloWorldBad {
    public static void main(String[] args) {
        //This loop prints numbers from 0 to 24
        for (int i = 0; i < 25; i++) {
            System.out.println("The value of i is " + i);
            //Fixed the if statement to use == instead of =
            if (i == 1) {
                System.out.println("i is equal to 1");
            }
        }
    }
}
