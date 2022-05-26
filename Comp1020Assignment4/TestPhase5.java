public class TestPhase5
{
 public static void main (String[] args)
 {
  //Testing the orderedInsertRec
  DoublyLinkedList myList = new DoublyLinkedList();
  
  myList.orderedInsertRec(new Node(22.1, null, null), myList.getLast());
  System.out.println(myList);
  
  myList.orderedInsertRec(new Node(5.55, null, null), myList.getLast());
  System.out.println(myList);
  
  myList.orderedInsertRec(new Node(1, null, null), myList.getLast());
  System.out.println(myList);
  
  myList.orderedInsertRec(new Node(111121212121212l, null, null), myList.getLast());
  System.out.println(myList);
  
  myList.orderedInsertRec(new Node(600, null, null), myList.getLast());
  System.out.println(myList);
  
  myList.orderedInsertRec(new Node(0.5, null, null), myList.getLast());
  System.out.println(myList);
  
  myList.orderedInsertRec(new Node(77.789, null, null), myList.getLast());
  System.out.println(myList);
  
  System.out.println();  //spacing
  
  
  //Testing the insertionSort
  DoublyLinkedList toSort = DoublyLinkedList.createList("list.txt");
  System.out.println("Before sorting:\n" + toSort);
  toSort.insertionSort();
  System.out.println("After sorting:\n" + toSort);
  
  System.out.println();  //spacing
  
  //2nd test for insertionSort
  DoublyLinkedList toSort2 = DoublyLinkedList.createList("list2.txt");
  System.out.println("Before sorting:\n" + toSort2);
  toSort2.insertionSort();
  System.out.println("After sorting:\n" + toSort2);
  
 }
}