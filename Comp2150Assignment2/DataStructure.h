#pragma once
class Node;
class NodeData;

class DataStructure
{
	private:
		Node * top;
	
	public:
		DataStructure();
		void setTop(Node *);
		Node * getTop();
		Node * removeTopNode();
		void printStructure();
		virtual void insertNode(NodeData *) = 0;
};

