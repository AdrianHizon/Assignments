// CLASS: NodeData
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: Used to hold different types of 
// objects in a Node.
//-----------------------------------------

#pragma once

class NodeData
{
	public:
		virtual void printData() = 0;
		virtual int compareTo(NodeData *) = 0;
};