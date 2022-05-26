// CLASS: PriorityQueue
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: A priority queue data structure
// where nodes are inserted in order based on
// a priority determined by the data in the node.
// Nodes are removed from the top.
//-----------------------------------------

#include "PriorityQueue.h"
#include "Node.h"
#include "NodeData.h"

//------------------------------------------------------
// insertNode
//
// PURPOSE: Inserts a node into the priority queue.
// PARAMETERS: Inserts the node in order based on its
// priority determined by its data.
//------------------------------------------------------
void PriorityQueue::insertNode(NodeData * data)
{
	Node * newNode = new Node(data);
	Node * currNode = getTop();
	if(currNode == nullptr)
	{
		setTop(newNode);
	}
	else
	{
		Node * prevNode = nullptr;
		while(currNode != nullptr && newNode->getData()->compareTo(currNode->getData()) <= 0)
		{
			prevNode = currNode;
			currNode = currNode->getNext();
		}
		if(prevNode == nullptr)
		{
			if(newNode->getData()->compareTo(currNode->getData()) >= 0)
			{
				newNode->setNext(currNode);
				setTop(newNode);
			}
			else
			{
				currNode->setNext(newNode);
			}
		}
		else
		{
			newNode->setNext(currNode);
			prevNode->setNext(newNode);
		}
	}
}