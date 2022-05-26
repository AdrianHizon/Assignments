// CLASS: DataStructure
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: An abstract data structure class
// that allows for different types of 
// data structures.
//-----------------------------------------

#include "DataStructure.h"
#include "Node.h"
#include <iostream>
using namespace std;

DataStructure::DataStructure()
{
	top = nullptr;
}

void DataStructure::setTop(Node * newTop)
{
	top = newTop;
}

Node * DataStructure::getTop()
{
	return top;
}

Node * DataStructure::removeTopNode()
{
	Node * currTop = top;
	top = top->getNext();
	return currTop;
}

void DataStructure::printStructure()
{
	Node * currNode = top;
	while(currNode != nullptr)
	{
		// cout << "starting print" << endl;
		currNode->printNode();
		currNode = currNode->getNext();
	}
}