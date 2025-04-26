/* 
Written by Gabe Gilkeson
For Mr. Gross's Software Development class
Borrowed from Mr. Gross's GitHub. https://github.com/kimgrossteacher/linkedlist

Description: This class represents a node in a doubly linked list that holds a StudentObject.
It contains methods to get and set the node's next and previous pointers, as well as its data.
*/
public class Node {

    Node next;
    Node previous;
    StudentObject data;

    //Constructor to initialize the node with data, next node, and previous node.
    Node(StudentObject data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    //Setters and getters for the node's next and previous pointers, as well as its data.

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setData(StudentObject data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
