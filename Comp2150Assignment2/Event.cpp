// CLASS: Event
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: An abstract Event class where 
// different subclasses of this have different
// effects in the simulation.
//-----------------------------------------

#include "Event.h"

Event::Event()
{
	order = nullptr;
	eventList = nullptr;
	orderList = nullptr;
	currentTime = 0;
}

Event::Event(NodeData * order, DataStructure * eventList, DataStructure * orderList, int currentTime, bool * chefReady)
{
	this->order = order;
	this->eventList = eventList;
	this->orderList = orderList;
	this->currentTime = currentTime;
	this->chefReady = chefReady;
}


//------------------------------------------------------
// compareTo
//
// PURPOSE: Compares the priority of this Event to another
// NodeData object to be used in a priority queue.
// PARAMETERS: Can receive any NodeData object but should
// only be receiving another Event object.
// Returns: Returns 0 if an Event is not received. Returns the
// priority comparison with lower time and lower order number
// being higher priority.
//------------------------------------------------------
int Event::compareTo(NodeData * data)
{
	int compareVal = 0;
	Event * event = dynamic_cast<Event *>(data);
	if(event != nullptr)
	{
		if(this->currentTime > event->currentTime)
		{
			compareVal = -1;
		}
		else if(this->currentTime < event->currentTime)
		{
			compareVal = 1;
		}
		else if(this->currentTime == event->currentTime)
		{
			FoodOrder * firstOrder = dynamic_cast<FoodOrder *>(this->order);
			FoodOrder * secondOrder = dynamic_cast<FoodOrder *>(event->getOrder());
			if(firstOrder != nullptr && secondOrder != nullptr)
			{
				if(firstOrder->getOrderNum() > secondOrder->getOrderNum())
				{
					compareVal = -1;
				}
				else if(firstOrder->getOrderNum() < secondOrder->getOrderNum())
				{
					compareVal = 1;
				}
				else
				{
					compareVal = 0;
				}
			}
		}
		else
		{
			compareVal = 0;
		}
	}
	return compareVal;
}

NodeData * Event::getOrder()
{
	return order;
}

DataStructure * Event::getEventList()
{
	return eventList;
}

DataStructure * Event::getOrderList()
{
	return orderList;
}

int Event::getCurrTime()
{
	return currentTime;
}

bool * Event::getChefReady()
{
	return chefReady;
}