// CLASS: Prepare
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: A Prepare event in the simulation 
// where an order begins being prepared by the chef
//-----------------------------------------

#include "Prepare.h"

Prepare::Prepare(NodeData * order, DataStructure * eventList, DataStructure * orderList, int currentTime, bool * chefReady) : Event(order, eventList, orderList, currentTime, chefReady){};

void Prepare::printData()
{
	FoodOrder * currOrder = dynamic_cast<FoodOrder *>(getOrder());
	if(currOrder != nullptr)
	{
		cout << "TIME: " << getCurrTime() << ", Food Order #" << currOrder->getOrderNum() << " is getting prepared by the chef!" << endl;
	}
}

//------------------------------------------------------
// processEvent
//
// PURPOSE: Processes this Prepare event to continue the simulation
//------------------------------------------------------
void Prepare::processEvent()
{
	printData();
	getEventList()->removeTopNode();
	(*getChefReady()) = false;
	FoodOrder * currOrder = dynamic_cast<FoodOrder *>(getOrder());
	if(currOrder != nullptr)
	{
		int newTime = getCurrTime() + currOrder->getPrepTime();
		NodeData * newComplete = new CompleteService(getOrder(), getEventList(), getOrderList(), newTime, getChefReady());
		getEventList()->insertNode(newComplete);
	}
	// getOrderList()->removeTopNode();
}