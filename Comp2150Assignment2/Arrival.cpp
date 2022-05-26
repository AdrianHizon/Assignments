// CLASS: Arrival
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: An Arrival event in the simulation 
// where a new order is placed.
//-----------------------------------------

#include "Arrival.h"

Arrival::Arrival()
{
	inputFile = nullptr;
}

Arrival::Arrival(NodeData * order, DataStructure * eventList, DataStructure * orderList, int currentTime, bool * chefReady, ifstream * inputFile, int numArrivals) : Event(order, eventList, orderList, currentTime, chefReady)
{
	this->inputFile = inputFile;
	this->numArrivals = numArrivals;
}

void Arrival::printData()
{
	FoodOrder * currOrder = dynamic_cast<FoodOrder *>(getOrder());
	if(currOrder != nullptr)
	{
		cout << "TIME: " << getCurrTime() << ", Food Order #" << currOrder->getOrderNum() << " arrives -> ";
		currOrder->printData();
	}
}

//------------------------------------------------------
// processEvent
//
// PURPOSE: Processes this Arrival event to continue the simulation
//------------------------------------------------------

void Arrival::processEvent()
{
	printData();
	getEventList()->removeTopNode();
	
	
	if((*getChefReady()) == true && getOrderList()->getTop() == nullptr)
	{
		NodeData * newPrepare = new Prepare(getOrder(), getEventList(), getOrderList(), getCurrTime(), getChefReady());
		getEventList()->insertNode(newPrepare);
	}
	else
	{
		getOrderList()->insertNode(getOrder());
	}
	
	string line;
	if(getline(*inputFile, line))
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
		numArrivals++;
		NodeData * newOrder = new FoodOrder(numArrivals, expiry, meal, numIngredients);
		NodeData * newArrival = new Arrival(newOrder, getEventList(), getOrderList(), time, getChefReady(), inputFile, numArrivals);
		getEventList()->insertNode(newArrival);
	}
}