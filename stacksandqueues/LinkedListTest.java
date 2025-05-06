/* 
Modified by Gabe Gilkeson
For Mr. Gross's Software Development class

Description: This program creates a linked list of student objects. 
It prompts the user to enter at least 5 students names, addresses, and IDs, 
and then stores each student in a linked list. Afterward, it prints the list
from front to back and from back to front.

Borrowed and modified from Mr. Gross's GitHub https://github.com/kimgrossteacher/linkedlist
*/

public class LinkedListTest {

    private Node head;
    private Node tail;

    public LinkedListTest() {
        head = null;
        tail = null;
    }

    //Adds a new student node to the end of the list
    public void enqueue(StudentObject data) {
        Node newNode = new Node(data, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    //Removes and returns the first student node
    public StudentObject dequeue() {
        if (head == null) return null;
        StudentObject data = head.data;
        head = head.next;
        if (head != null) head.previous = null;
        else tail = null;
        return data;
    }

    //Adds a new student node to the end of the list
    public void push(StudentObject data) {
        Node newNode = new Node(data, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    //Removes and returns the last student node
    public StudentObject pop() {
        if (tail == null) return null;
        StudentObject data = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        return data;
    }

    //Returns true if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    //Prints all students from front to back
    public void printFromFront() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    //Prints all students from back to front
    public void printFromBack() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.previous;
        }
    }
}
