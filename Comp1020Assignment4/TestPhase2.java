public class TestPhase2
{
 public static void main (String[] args)
 {
  DoublyLinkedList myList = DoublyLinkedList.createList("list3.txt");
  
  System.out.println(myList);
  System.out.println(myList.toStringReversed());
  
  myList.insertionSort();
  
  System.out.println("\n" + myList);
  System.out.println(myList.toStringReversed());
  
  System.out.println("The list has a size of: " + myList.size());
 }
}