public class TestPhase4
{
	public static void main (String[] args)
	{
		DoublyLinkedList myList = DoublyLinkedList.createList("list.txt");
		
		System.out.println(myList);
		System.out.println("The Node with the max value contains: " + myList.findMax().getData());
		
		Node n1 = myList.remove(0);
		Node n2 = myList.remove(0);
		System.out.println(n1.compareTo(n2) < 0);
		
		System.out.println(myList);
		
		Node n3 = myList.remove(3);
		Node n4 = myList.remove(3);
		System.out.println(n3.compareTo(n4) < 0);
		
		System.out.println(myList);
		
		Node n5 = myList.remove(6);
		Node n6 = myList.remove(6);
		System.out.println(n5.compareTo(n6) < 0);
		
		System.out.println(myList);
		
		System.out.println("The Node with the max value contains: " + myList.findMax().getData());
		
		myList.addFront(9.99);
		System.out.println(myList);
		System.out.println("The Node with the max value contains: " + myList.findMax().getData());
		
	}
}