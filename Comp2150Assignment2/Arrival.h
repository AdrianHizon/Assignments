#pragma once
#include "Event.h"
#include "Prepare.h"
#include <string>
#include <iostream>
#include <sstream>
#include <fstream>
class DataStructure;

class Arrival : public Event
{
	private:
		ifstream * inputFile;
		int numArrivals;
	
	public:
		Arrival();
		Arrival(NodeData *, DataStructure *, DataStructure *, int, bool *, ifstream *, int);
		void printData();
		void processEvent();
};