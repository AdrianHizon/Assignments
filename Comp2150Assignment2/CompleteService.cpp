// CLASS: CompleteService
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: A CompleteService event in the simulation 
// where an order is completed and served.
//-----------------------------------------

#include "CompleteService.h"

CompleteService::CompleteService(NodeData * order, DataStructure * eventList, DataStructure * orderList, int currentTime, bool * chefReady) : Event(order, eventList, orderList, currentTime, chefReady){};

void CompleteService::printData()
{
	FoodOrder * currOrder = dynamic_cast<FoodOrder *>(getOrder());
	if(currOrder != nullptr)
	{
		cout << "TIME: " << getCurrTime() << ", Food Order #" << currOrder->getOrderNum() << " has been served! Revenue grew by: $" << currOrder->getPrice() << endl;
	}
}

//------------------------------------------------------
// processEvent
//
// PURPOSE: Processes this CompleteService event to continue the simulation
//------------------------------------------------------
void CompleteService::processEvent()
{
	printData();
	getEventList()->removeTopNode();
	(*getChefReady()) = true;
	if(getOrderList()->getTop() != nullptr)
	{
		FoodOrder * topOrder = dynamic_cast<FoodOrder *>(getOrderList()->getTop()->getData());
		while(topOrder != nullptr && getCurrTime() > topOrder->getExpiry())
		{
			getOrderList()->removeTopNode();
			if(getOrderList()->getTop() != nullptr)
			{
				topOrder = dynamic_cast<FoodOrder *>(getOrderList()->getTop()->getData());
			}
			else
			{
				topOrder = nullptr;
			}
		}
	}
	
	if(getOrderList()->getTop() != nullptr)
	{
		NodeData * newPrepare = new Prepare(getOrderList()->getTop()->getData(), getEventList(), getOrderList(), getCurrTime(), getChefReady());
		getEventList()->insertNode(newPrepare);
		getOrderList()->removeTopNode();
		(*getChefReady()) = false;
	}
}