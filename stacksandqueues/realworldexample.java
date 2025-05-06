/* 
Written by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program shows a simple DMV line example.
It adds three people to a queue and serves them in order.
*/

public class realworldexample {
    public static void main(String[] args) {
        LinkedListTest dmvLine = new LinkedListTest(); //DMV line is a queue

        System.out.println("DMV Queue Example\n");

        //Add three people to the line
        dmvLine.enqueue(new StudentObject("Alice", "111 Main St", "1"));
        dmvLine.enqueue(new StudentObject("Bob", "222 Elm St", "2"));
        dmvLine.enqueue(new StudentObject("Charlie", "333 Oak St", "3"));

        //Serve people in the order they came
        while (!dmvLine.isEmpty()) {
            System.out.println("Now serving: " + dmvLine.dequeue());
        }

        System.out.println("\nAll customers have been served.");
    }
}
