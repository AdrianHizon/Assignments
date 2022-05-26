/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #4
 * Phase 4
 * 
 * Purpose: Creates a node that contains a Number object and a pointer to previous and next node in the linked list
 */

public class Node
{
  /*
   The following code is provided. You are not allowed to modify it.
   */
  
  //
  //Instance variables
  //
  private Number data; //the data stored in the node must be a subclass of Number (in our assignment, it could be either an Integer, Double or Long)
  
  private Node previous;  //a link to the previous Node
  private Node next;  //a link to the next Node
  
  
  //
  //Constructor
  //
  public Node(Number data, Node previous, Node next)
  {
    this.data = data;
    this.previous = previous;
    this.next = next;
  }
  
  
  //
  //Instance methods
  //
  
  //accessor for the data
  public Number getData()
  {
    return data;
  }
  
  //accessor for the previous Node
  public Node getPrevious()
  {
    return previous;
  }
  
  //accessor for the next Node
  public Node getNext()
  {
    return next;
  }
  
  //mutator for the previous Node
  public void setPrevious(Node newPrev)
  {
    previous = newPrev;
  }
  
  //mutator for the next Node
  public void setNext(Node newNext)
  {
    next = newNext;
  }
  
  /*
   End of the provided code.
   */
  
  //Add your code below.
  
  /*
   * Receives a node which is then compared to the node this method is called on
   * Returns a 1 if this node is greater than the received node
   * Returns a 0 if both nodes are equal
   * Returns a -1 if this node is less than the received node
   */
  public int compareTo(Node n){
    if(this.getData() instanceof Double){
      if(n.getData() instanceof Double){
        return ((Double)this.getData()).compareTo(((Double)n.getData()));
      }
      else{
        return 1;
      }
    }
    else if(this.getData() instanceof Long){
      if(n.getData() instanceof Double){
        return -1;
      }
      else if(n.getData() instanceof Long){
        return ((Long)this.getData()).compareTo(((Long)n.getData()));
      }
      else{
        return 1;
      }
    }
    else{
      if(n.getData() instanceof Integer){
        return ((Integer)this.getData()).compareTo(((Integer)n.getData()));
      }
      else{
        return -1;
      }
    }
  }
}