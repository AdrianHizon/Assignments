// CLASS: Node
//
// Author: Adrian Hizon, 7867173
//
// PURPOSE: These are the nodes that are used
//          in the linked list.
//-----------------------------------------

public class Node 
{
	private Node next;
	private NodeData data;
	
	public Node(NodeData data)
	{
		next = null;
		this.data = data;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node newNode)
	{
		next = newNode;
	}
	
	public NodeData getData()
	{
		return data;
	}
	
	public void printNode()
	{
		data.printData();
	}
	
//	public abstract void printNode();
//	public abstract Node deepCopy();
}
