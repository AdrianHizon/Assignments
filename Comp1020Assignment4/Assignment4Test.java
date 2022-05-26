import java.io.*;
import java.util.*;

public class Assignment4Test{
  public static void main(String[] args){
    DoublyLinkedList myList = new DoublyLinkedList();
    
    myList.orderedInsertRec(new Node(1.0, null, null), myList.getLast());
    System.out.println(myList);
    
    myList.orderedInsertRec(new Node(1.0, null, null), myList.getLast());
    System.out.println(myList);
    
    myList.orderedInsertRec(new Node(1.0, null, null), myList.getLast());
    System.out.println(myList);
    
    myList.orderedInsertRec(new Node(1, null, null), myList.getLast());
    System.out.println(myList);
    
    myList.orderedInsertRec(new Node(0, null, null), myList.getLast());
    System.out.println(myList);
    
    myList.orderedInsertRec(new Node(0, null, null), myList.getLast());
    System.out.println(myList);
    
    myList.orderedInsertRec(new Node(1, null, null), myList.getLast());
    System.out.println(myList);
    /*
    System.out.println("Testing int and int.");
    dll.addFront(4);
    dll.addFront(4);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()) + "\n");
    
    System.out.println("Testing int and long.");
    dll = new DoublyLinkedList();
    dll.addFront(3l);
    dll.addFront(4);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()));
    
    System.out.println("Testing int and double.");
    dll = new DoublyLinkedList();
    dll.addFront(3.0);
    dll.addFront(4);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()));
    
    System.out.println("Testing long and int.");
    dll = new DoublyLinkedList();
    dll.addFront(5);
    dll.addFront(4l);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()));
    
    System.out.println("Testing long and long.");
    dll = new DoublyLinkedList();
    dll.addFront(4l);
    dll.addFront(4l);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()));
    
    System.out.println("Testing long and double.");
    dll = new DoublyLinkedList();
    dll.addFront(3.0);
    dll.addFront(4l);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()));
    
    System.out.println("Testing double and int.");
    dll = new DoublyLinkedList();
    dll.addFront(4);
    dll.addFront(9.99);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()));
    
    System.out.println("Testing double and long.");
    dll = new DoublyLinkedList();
    dll.addFront(5l);
    dll.addFront(4.0);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()));
    
    System.out.println("Testing double and double.");
    dll = new DoublyLinkedList();
    dll.addFront(5.0);
    dll.addFront(5.0);
    System.out.println(dll);
    System.out.println(dll.getFirst().compareTo(dll.getFirst().getNext()));
    */
  }
}