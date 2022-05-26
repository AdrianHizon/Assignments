// CLASS: FoodOrder
//
// Author: Adrian Hizon, 7867173
//
// REMARKS: An order placed by a customer in
// the simulation.
//-----------------------------------------

#include "FoodOrder.h"

FoodOrder::FoodOrder()
{
	orderNumber = 0;
	expiry = 0;
	mealName = nullptr;
	ingredients = 0;
	prepTime = 0;
	price = 0;
}

FoodOrder::FoodOrder(int orderNumber, int expiry, string mealName, int ingredients)
{
	this->orderNumber = orderNumber;
	this->expiry = expiry;
	this->mealName = mealName;
	this->ingredients = ingredients;
	if(mealName.compare("Salad") == 0)
	{
		prepTime = 3;
		price =  6.99;
	}
	else if(mealName.compare("Burger") == 0)
	{
		prepTime = 4;
		price = 8.99;
	}
	else if(mealName.compare("Pizza") == 0)
	{
		prepTime = 6;
		price = 12.99;
	}
	else if(mealName.compare("Stew") == 0)
	{
		prepTime = 7;
		price = 14.99;
	}
	else
	{
		prepTime = 0;
		price = 0;
	}
	prepTime += ingredients;
	price += ingredients;
}

int FoodOrder::getOrderNum()
{
	return orderNumber;
}

int FoodOrder::getExpiry()
{
	return expiry;
}

int FoodOrder::getPrepTime()
{
	return prepTime;
}

double FoodOrder::getPrice()
{
	return price;
}

void FoodOrder::printData()
{
	cout << "Expiry: " << expiry << " - Meal: " << mealName << " - Ingredients: " << ingredients << " - Prep. Time: " << prepTime << " - Price: $" << price << endl;
}

//------------------------------------------------------
// compareTo
//
// PURPOSE: Compares the priority of this FoodOrder to another
// NodeData object to be used in a priority queue.
// PARAMETERS: Can receive any NodeData object but should
// only be receiving another FoodOrder object.
// Returns: Returns 0 if an Event is not received. Returns the
// priority comparison with higher price being higher priority.
//------------------------------------------------------
int FoodOrder::compareTo(NodeData * data)
{
	int compareVal = 0;
	FoodOrder * order = dynamic_cast<FoodOrder *>(data);
	if(order != nullptr)
	{
		if(this->price > order->price)
		{
			compareVal = 1;
		}
		else if(this->price < order->price)
		{
			compareVal = -1;
		}
		else
		{
			compareVal = 0;
		}
	}
	return compareVal;
}