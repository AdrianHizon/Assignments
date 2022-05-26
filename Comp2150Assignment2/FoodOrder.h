#pragma once
#include "NodeData.h"
#include <string>
#include <iostream>
using namespace std;

class FoodOrder : public NodeData
{
	private:
		int orderNumber;
		int expiry;
		string mealName;
		int ingredients;
		int prepTime;
		double price;
		
	public:
		FoodOrder();
		FoodOrder(int, int, string, int);
		int getOrderNum();
		int getExpiry();
		int getPrepTime();
		double getPrice();
		void printData();
		int compareTo(NodeData *);
};