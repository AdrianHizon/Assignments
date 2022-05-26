//-----------------------------------------
 // NAME		: Adrian Hizon
 // STUDENT NUMBER	: 7867173
 // COURSE		: COMP 2150
 // INSTRUCTOR	: Jonathan Boisvert
 // ASSIGNMENT	: Assignment 2
 // 
 // REMARKS: Create an event driven simulation that takes new event inputs from a file
 //-----------------------------------------

#include "Simulation.h"

int main(int argc, char* argv[])
{
	if(argc != 3)
	{
		cout<<"USAGE: Main filename simulationType"<< endl;
		cout<<"where simulationType is either 1, 2 or 3."<< endl;
		return 0;
	}
	
	string filename = argv[1];
	string version = argv[2];
	
	cout << "The filename is: " << filename << endl;
	cout << "The version selected is: " << version <<endl;
	
	Simulation * simulation = new Simulation(filename, version);
	simulation->runSimulation();
}