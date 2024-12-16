/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program creates an array and tries to access an out of bounds index,
which causes an exception that is caught, allowing the program to continue. The program
then tries to divide by zero, which causes an arithmetic error that is caught,
allowing the program to continue. Then it prints a message saying that the errors
were caught and the program will continue running without crashing.
*/
public class exceptionhandling {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        try {
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Attempted to print an invalid array index error: " + e);
        }

        try {
            System.out.println(12/0);
        } catch (ArithmeticException e) {
            System.out.println("It is not possible to divide by zero error: " + e);
        }

        System.out.println("The program caught the errors. Rest of the code can continue here without the program crashing.");
    }
}