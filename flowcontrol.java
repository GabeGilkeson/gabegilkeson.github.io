public class flowcontrol {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            String evenOrOdd;
            if (i % 2 == 0) {
                evenOrOdd = " even";
            } else {
                evenOrOdd = " odd";
            }

            System.out.println(i + evenOrOdd);

            sum += i;
        }

        System.out.println("Sum of numbers: " + sum);
    }
}