#pragma once
class NodeData;

class Node
{
	private:
		NodeData * data;
		Node * next;
	
	public:
		Node(NodeData *);
		void setNext(Node *);
		NodeData * getData();
		Node * getNext();
		void printNode();
};