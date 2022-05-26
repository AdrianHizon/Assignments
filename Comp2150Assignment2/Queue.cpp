// CLASS: Queue
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: An queue data structure where
// nodes are inserted at end and removed
// from the top.
//-----------------------------------------

#include "Queue.h"
#include "Node.h"

//------------------------------------------------------
// insertNode
//
// PURPOSE: Inserts a node into the priority queue.
// PARAMETERS: Inserts the node at the end of the queue.
//------------------------------------------------------
void Queue::insertNode(NodeData * data)
{
	Node * newNode = new Node(data);
	Node * currNode = getTop();
	if(getTop() == nullptr)
	{
		setTop(newNode);
	}
	else
	{
		Node * prevNode = nullptr;
		while(currNode != nullptr)
		{
			prevNode = currNode;
			currNode = currNode->getNext();
		}
		newNode->setNext(currNode);
		prevNode->setNext(newNode);
	}
}