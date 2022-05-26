// CLASS: LinkedList
//
// Author: Adrian Hizon, 7867173
//
// PURPOSE: This a linked list data structure that
//          can hold different types of objects.
//-----------------------------------------

public class LinkedList 
{
	private Node top;
	private int nodeCount;
	
	public LinkedList()
	{
		top = null;
		nodeCount = 0;
	}
	
	public Node getTop()
	{
		return top;
	}
	
	public int getNodeCount()
	{
		return nodeCount;
	}
	
	
	//------------------------------------------------------
    // insertNode
    //
    // PURPOSE: Inserts a node in the list
    // PARAMETERS: Receives a data to put into the new node
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean insertNode(NodeData data)
	{
		boolean success = false;
		Node newNode = new Node(data);
		if(data != null)
			{
			if(top == null)
			{
				top = newNode;
			}
			else
			{
				Node currNode = top;
				
				while(currNode.getNext() != null)
				{
					currNode = currNode.getNext();
				}
				
				currNode.setNext(newNode);
			}
			success = true;
			nodeCount++;
		}
		else
		{
			System.out.println("Trying to insert invalid data");
		}
		return success;
	}
	
	
	//------------------------------------------------------
    // deleteNode
    //
    // PURPOSE: Deletes a node in the list
    // PARAMETERS: Receives a NodeData object to find the right node to delete
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean deleteNode(NodeData data)
	{
		boolean success = false;
		Node currNode = top;
		Node prevNode = null;
		
		while(currNode != null && currNode.getData() != data)
		{
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		
		if(currNode != null)
		{
			if(currNode == top)
			{
				top = currNode.getNext();
			}
			else
			{
				prevNode.setNext(currNode.getNext());
				currNode.setNext(null);
				currNode = null;
			}
			success = true;
			nodeCount--;
		}
		
		if(success == false)
		{
			System.out.println("Attempting to delete nonexistent node.");
		}
		return success;
	}
	
	//------------------------------------------------------
    // deleteNode
    //
    // PURPOSE: Deletes the first node in the list
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean deleteFirst()
	{
		boolean success = false;
		if(top != null)
		{
			top = top.getNext();
			nodeCount--;
			success = true;
		}
		return success;
	}
	
	
	//------------------------------------------------------
    // deleteNode
    //
    // PURPOSE: Deletes the last node in the list
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean deleteLast()
	{
		boolean success = false;
		Node currNode = top;
		Node prevNode = top;
		
		while(currNode != null)
		{
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		
		if(prevNode != null)
		{
			if(prevNode == top)
			{
				top = null;
			}
			else
			{
				prevNode.setNext(null);
			}
			nodeCount--;
			success = true;
		}
		
		return success;
	}
	
	public void printList()
	{
		Node currNode = top;
		while(currNode != null)
		{
			currNode.printNode();
			currNode = currNode.getNext();
		}
	}
	
	
}
