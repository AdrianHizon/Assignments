#pragma once
#include "NodeData.h"
#include "DataStructure.h"
#include "FoodOrder.h"
#include <string>
#include <iostream>
using namespace std;

class Event : public NodeData
{
	private:
		NodeData * order;
		DataStructure * eventList;
		DataStructure * orderList;
		int currentTime;
		bool * chefReady;
	
	public:
		virtual void printData() = 0;
		virtual void processEvent() = 0;
		Event();
		Event(NodeData *, DataStructure *, DataStructure *, int, bool *);
		int compareTo(NodeData *);
		NodeData * getOrder();
		DataStructure * getEventList();
		DataStructure * getOrderList();
		// int getOrderNum();
		int getCurrTime();
		bool * getChefReady();
};