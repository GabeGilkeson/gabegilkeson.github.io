public class LinkedListTest {

    private Node head;
    private Node tail;
    private Node current;
  
    LinkedListTest(){
          head=null;
          tail=head;
          current=null;
          }
          
    // inserts a new node just after the current node and moves current to the new node

     public void insertNode(StudentObject data){
      Node temp=new Node (data, null,null);
        temp.previous=current;
        temp.next=current.next;
        current=temp;
      
     }     

     // adds a new node at the end of the linked list  Sets the new nodes previous to point to current tail, then changes tail to point to the new node
     //and the next on the old tail to point to the new node     
    public void addNode(StudentObject data){
    Node current= new Node(data, null, null );
        if (head==null){ // if there are no nodes in the list, set this node to the head and tail.

            head=current; 
            tail=current;
            return;
        }else{
          tail.next=current;// set the current tail.next to be the new node.
          current.previous=tail;// set the new tails, previous to the old tail
          tail=current;// replace tail with the new node.
        }
     }
 
    //removes a node and returns the object that was stored in the node.  Changes the previous node and next node to link to each other.
 
    public StudentObject removeNode(Node current){
          current.next.setPrevious(current.previous);
          current.previous.setNext(current.next);
          return current.data;
     }
     // returns true if there is a node after the current node (ie the node is not the tail)
     public boolean hasNext(){
      if (current.next==null){
        return false;
      }
      return true;
    }
    //returns true if there is a node before this node (ie node is not the head)
    public boolean hasPrevious(){
      if (current.previous==null){
        return false;
      }
      return true;
    }
    //moves current to the next node and returns the data in that node;
    public StudentObject getNext(){
    if (current.getNext()!=null){
      current=current.next;
      return current.data;
    }
    return null;
  }
  // moved the current node to previous and returns the data in that node

  public StudentObject getPrevious(){
    if (current.previous!=null){
      current=current.previous;
      return current.data;
    }
    return null;
  }

  // moves the current node to the head and returns that data. 
    public StudentObject getHead(){
      current=head;
      return current.data;
    }

    // moves the current node to the tail and returns that data. 
    public StudentObject getTail(){
      current=tail;
      return current.data;
    }
 
 }
