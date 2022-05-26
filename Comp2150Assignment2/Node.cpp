// CLASS: Node
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: A node to be used in a data structure
//-----------------------------------------

#include "Node.h"
#include "NodeData.h"
class DataNode;

Node::Node(NodeData * newData)
{
	this->data = newData;
}

void Node::setNext(Node * nextNode)
{
	next = nextNode;
}

NodeData * Node::getData()
{
	return data;
}

Node * Node::getNext()
{
	return next;
}

void Node::printNode()
{
	data->printData();
}