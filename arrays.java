/*
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program counts from 1 to 100 and determines if the numbers are even or odd. It then adds the sum of the numbers.
*/
public class arrays {
    public static void main(String[] args) {
        int sum = 0;

        int[] numbers = new int[100];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            String evenOrOdd;
            if (number % 2 == 0) {
                evenOrOdd = " even";
            } else {
                evenOrOdd = " odd";
            }

            System.out.println(number + evenOrOdd);

            sum += number;
        }

        System.out.println("Sum of numbers: " + sum);
    }
}