// CLASS: Stack
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: A stack data structure where
// nodes are inserted at the top
// and removed from the top.
//-----------------------------------------

#include "Stack.h"
#include "Node.h"

//------------------------------------------------------
// insertNode
//
// PURPOSE: Inserts a node into the priority queue.
// PARAMETERS: Inserts the node at the top of the stack.
//------------------------------------------------------
void Stack::insertNode(NodeData * data)
{
	Node * newNode = new Node(data);
	if(getTop() != nullptr)
	{
		newNode->setNext(getTop());
	}
	setTop(newNode);
}
