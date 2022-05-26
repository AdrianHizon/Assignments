/*
 * COMP 1020 Section A01
 * Instructor: Ali Neshati
 * Name: Adrian Hizon
 * Assignment #4
 * Phase 1-5
 * 
 * Purpose: Creates a doubly linked list where each node is connected to the previous and next node.
 */

import java.io.*;
import java.util.*;

public class DoublyLinkedList
{
  /*
   The following code is provided. You are not allowed to modify it.
   */
  
  //
  //Instance variables
  //
  private Node first;  //the first Node (or the top Node) of the list
  private Node last;  //the last Node of the list
  
  //
  //Instance methods
  //
  
  //accessor for the first Node
  public Node getFirst()
  {
    return first;
  }
  
  //accessor for the last Node
  public Node getLast()
  {
    return last;
  }
  
  
  /*
   End of the provided code.
   */
  
  //Add your code below.
  
  /*
   * Receives a Number input and creates a Node containing it
   * Adds the created Node to the start of the linked list
   */
  public void addFront(Number n){
    Node newFirst = new Node(n, null, first); //The node that will become the first Node of the list
    if(first == null && last == null){
      last = newFirst;
    }
    else{
      first.setPrevious(newFirst);
    }
    first = newFirst;
  }
  
  /*
   * Receives a Number input and creates a Node containing it
   * Adds the created Node to the end of the linked list
   */
  public void addEnd(Number n){
    Node newLast = new Node(n, last, null); //The node that will become the last Node of the list
    if(first == null && last == null){
      first = newLast;
    }
    else{
      last.setNext(newLast);
    }
    last = newLast;
  }
  
  /*
   * Interface method that returns the amount of nodes in the linked list
   */
  public int size(){
    if(first == null){
      return 0;
    }
    else{
      return sizeRec(first);
    }
  }
  
  /*
   * Receives a node parameter that keeps track of the current node when searching through the linked list
   * Uses recursion to find the amount of nodes in the linked list
   */
  private int sizeRec(Node currentNode){
    if(currentNode.getNext() == null){
      return 1;
    }
    else{
      return sizeRec(currentNode.getNext()) + 1;
    }
  }
  
  /*
   * Interface method that returns a String that represents a DoublyLinkedList object
   */
  public String toString(){
    String s = "<< ";
    if(first != null){
      s += toStringRec(first);
    }
    s += " >>";
    return s;
  }
  
  /*
   * Receives a node parameter that keeps track of the current node when searching through the linked list
   * Uses recursion to create and return a String that represents the DoublyLinkedList object
   */
  private String toStringRec(Node currentNode){
    if(currentNode.getNext() == null){
      return currentNode.getData() + "";
    }
    else{
      return currentNode.getData() + " " + toStringRec(currentNode.getNext()); 
    }
  }
  
  /*
   * Interface method that returns a String that represents a reversed DoublyLinkedList 
   */
  public String toStringReversed(){
    String s = "<< ";
    if(last != null){
      s += toStringReversedRec(last);
    }
    s += " >>";
    return s;
  }
  
  /*
   * Receives a node parameter that keeps track of the current node when searching through the linked list
   * Uses recursion to create and return a String that represents a reversed DoublyLinkedList
   */
  private String toStringReversedRec(Node currentNode){
    if(currentNode.getPrevious() == null){
      return currentNode.getData() + "";
    }
    else{
      return currentNode.getData() + " " + toStringReversedRec(currentNode.getPrevious());
    }
  }
  
  /*
   * Receives a String that represents a filename and opens the file
   * Creates a DoublyLinkedList object using the information received from the file
   */
  public static DoublyLinkedList createList(String fileName){
    DoublyLinkedList newList = new DoublyLinkedList();
    try{
      BufferedReader input = new BufferedReader(new FileReader(fileName));
      Scanner scan = new Scanner(input);
      parseScanner(scan, newList);
      input.close();
      scan.close();
    }
    catch(IOException e){
      e.printStackTrace();
    }
    return newList;
  }
  
  /*
   * Receives a Scanner, and a DoublyLinkedList
   * Uses recursion and the received Scanner to parse the text file received in the createList method
   * Adds the parsed information to the received DoublyLinkedList
   */
  private static void parseScanner(Scanner s, DoublyLinkedList linkedList){
    if(s.hasNext() == false){
      return;
    }
    else{
      if(s.hasNextInt() == true){
        linkedList.addEnd(s.nextInt());
        parseScanner(s, linkedList);
      }
      else if(s.hasNextLong() == true){
        linkedList.addEnd(s.nextLong());
        parseScanner(s, linkedList);
      }
      else if(s.hasNextDouble() == true){
        linkedList.addEnd(s.nextDouble());
        parseScanner(s, linkedList);
      }
      else{
        s.next();
        parseScanner(s, linkedList);
      }
    }
  }
  
  /*
   * Receives a node as a parameter and removes it from the linked list
   */
  private void removeNode(Node n){
    if(n == first && n == last){
      first = null;
      last = null;
    }
    else if(n == first){
      first = n.getNext();
      first.setPrevious(null);
    }
    else if(n == last){
      last = n.getPrevious();
      last.setNext(null);
    }
    else{
      n.getPrevious().setNext(n.getNext());
      n.getNext().setPrevious(n.getPrevious());
    }
  }
  
  /*
   * Receives an integer that indicates the position of a node in the linked list
   * Removes the node at the position indicated
   */
  public Node remove(int i){
    if(i < 0 || i >= this.size()){
      throw new IndexOutOfBoundsException();
    }
    return removeRec(i, first);
  }
  
  /*
   * Receives an integer to keep track of the position in the linked list
   * Receives a node parameter that keeps track of the current node when searching through the linked list
   * Uses recursion to remove a node at a specific position in the linked list
   */
  private Node removeRec(int i, Node currentNode){
    if(i == 0){
      this.removeNode(currentNode);
      return currentNode;
    }
    else{
      return removeRec(i - 1, currentNode.getNext());
    }
  }
  
  /*
   * Interface method to find the node largeset node in the linked list
   */
  public Node findMax(){
    if(this.size() == 0){
      return null;
    }
    else{
      return findMaxRec(this.size(), first, first);
    }
  }
  
  /*
   * Receives an integer that keeps track of the position in the linked list
   * Receives a node parameter that keeps track of current max node when searching through the linked list
   * Receives a node parameter that keeps track of the current node when searching through the linked list
   * Uses recursion to find the largest node in the linked list
   */
  private Node findMaxRec(int i, Node currentMax, Node currentNode){
    if(i == 1){
      return currentMax;
    }
    else{
      if(currentMax.compareTo(currentNode.getNext()) == -1){
        return findMaxRec(i - 1, currentNode.getNext(), currentNode.getNext());
      }
      else{
        return findMaxRec(i - 1, currentMax, currentNode.getNext());
      }
    }
  }
  
  /*
   * Uses recursion to insert a new node into the linked list in an ordered fashion using the node compareTo method
   * Receives a node to be inserted and a node to keep track of the position in the linked list
   */
  public void orderedInsertRec(Node toInsert, Node current){
    if(current == null){
      addFront(toInsert.getData());
    }
    else if(current == last && toInsert.compareTo(current) >= 0){
      addEnd(toInsert.getData());
    }
    else if(toInsert.compareTo(current) > -1){
      current.getNext().setPrevious(toInsert);
      toInsert.setNext(current.getNext());
      toInsert.setPrevious(current);
      current.setNext(toInsert);
    }
    else{
      orderedInsertRec(toInsert, current.getPrevious());
    }
  }
  
  /*
   * Interface method for insertion sorting a doubly linked list
   */
  public void insertionSort(){
    insertionSortRec(0);
  }
  
  /*
   * Uses recursion insertion sort a doubly linked list
   * Receives an integer parameter that keeps track of how much of the list has been sorted
   */
  private void insertionSortRec(int sorted){
    if(sorted == this.size()){
      return;
    }
    else{
      Node sortedNode = this.remove(sorted);
      orderedInsertRec(sortedNode, sortedNode.getPrevious());
      insertionSortRec(++sorted);
    }
  }
}