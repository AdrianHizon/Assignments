// CLASS: Simulation
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: The class that handles running the
// event driven simulation.
//-----------------------------------------

#include "Simulation.h"

Simulation::Simulation(string fileName, string simType)
{
	this->fileName = fileName;
	this->simTypeInt = stoi(simType);
	eventList = new PriorityQueue();
	if(simTypeInt == 1)
	{
		orderList = new Queue();
	}
	else if(simTypeInt == 2)
	{
		orderList = new Stack();
	}
	else if(simTypeInt == 3)
	{
		orderList = new PriorityQueue();
	}
	else
	{
		orderList = new Queue();
	}
}

//------------------------------------------------------
// runSimulation
//
// PURPOSE: Runs the event driven simulation which prints
// the results. The type of simulation was determined 
// during the creation of simulation object.
//------------------------------------------------------
void Simulation::runSimulation()
{
	ifstream * inputFile = new ifstream(fileName);
	string line;
	if(getline(*inputFile, line))  //gets the next line from the file and saves it in 'line', if there is one
	{
		stringstream sst(line);  //stringstream allows us to parse the line token by token (kind of like a Scanner in Java)
		string token;
		int counter = 0;
		int time = 0;
		int expiry = 0;
		string meal = "";
		int numIngredients = 0;
		
		while(sst >> token)  //grabing one token at a time, until there is no token left
		{
			if(counter == 0) //reading time
				time = stoi(token);
			else if(counter == 1) //reading expiry
				expiry = stoi(token);
			else if(counter == 2) //reading meal type
				meal = token;
			else //counting ingredients from here (if counter > 2)
			{
				numIngredients++;
			}
			counter++;
		}
		NodeData * newOrder = new FoodOrder(1, expiry, meal, numIngredients);
		bool * chefReady = new bool(true);
		NodeData * newArrival = new Arrival(newOrder, eventList, orderList, time, chefReady, inputFile, 1);
		eventList->insertNode(newArrival);
	}
	
	
	Node * currNode = eventList->getTop();
	while(eventList->getTop() != nullptr)
	{
		Event * currEvent = dynamic_cast<Event *>(eventList->getTop()->getData());
		if(currEvent != nullptr)
		{
			CompleteService * currService = dynamic_cast<CompleteService *>(currEvent);
			if(currService != nullptr)
			{
				ordersCompleted++;
				FoodOrder * currOrder = dynamic_cast<FoodOrder *>(currService->getOrder());
				totalRevenue += currOrder->getPrice();
			}
			currEvent->processEvent();
		}
	}
	cout << "- Total number of orders completed: " << ordersCompleted << "\n- Total revenue: $" << totalRevenue << endl;
}