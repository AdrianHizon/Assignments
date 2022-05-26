#pragma once
#include "Event.h"
#include "Prepare.h"
#include "Node.h"
#include <iostream>

class CompleteService : public Event
{
	private:
		
	
	public:
		CompleteService(NodeData *, DataStructure *, DataStructure *, int, bool * chefReady);
		void printData();
		void processEvent();
};