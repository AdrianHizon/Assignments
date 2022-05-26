public class TestPhase1
{
 public static void main (String[] args)
 {
  DoublyLinkedList myList = new DoublyLinkedList();
  myList.addFront(111);
  System.out.println(myList);
  
  myList.addEnd(222.2);
  System.out.println(myList);
  
  myList.addEnd(3000000000l);
  System.out.println(myList);
  
  myList.addFront(0.777);
  System.out.println("\n" + myList);
  
  myList.insertionSort();
  
  System.out.println(myList);
  System.out.println(myList.toStringReversed());
  
  System.out.println("The list has a size of: " + myList.size());
 }
}