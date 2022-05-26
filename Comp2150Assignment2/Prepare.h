#pragma once
#include "Event.h"
#include "CompleteService.h"
#include <iostream>

class Prepare : public Event
{
	private:
		
	
	public:
		Prepare(NodeData *, DataStructure *, DataStructure *, int, bool *);
		void printData();
		void processEvent();
};