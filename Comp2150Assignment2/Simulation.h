#pragma once
#include "DataStructure.h"
#include "Queue.h"
#include "Stack.h"
#include "PriorityQueue.h"
#include "Node.h"
#include "FoodOrder.h"
#include "Event.h"
#include "Arrival.h"
#include <string>
#include <iostream>
#include <string>
#include <sstream>
#include <fstream> 
using namespace std;

class Simulation
{
	private:
		string fileName;
		int simTypeInt;
		DataStructure * eventList;
		DataStructure * orderList;
		int ordersCompleted;
		double totalRevenue;
	
	public:
		Simulation(string, string);
		void runSimulation();
	
};