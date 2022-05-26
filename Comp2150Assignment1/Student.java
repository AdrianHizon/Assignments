// CLASS: Student
//
// Author: Adrian Hizon, 7867173
//
// PURPOSE: A user that is a student 
//
//-----------------------------------------

public class Student extends User 
{
	public Student(String id)
	{
		super(id);
	}
	
	//------------------------------------------------------
    // report
    //
    // PURPOSE: Prints a report of the student
    //------------------------------------------------------
	public void report()
	{
		int totalCost = 0;
		System.out.println("\nReport for student \"" + super.getId() + "\"\n---------------------------------------------");
		Node currNode = super.getAppList().getTop();
		Appointment currApp;
		while(currNode != null)
		{
			if(currNode.getData() instanceof Appointment)
			{
				currApp = (Appointment)currNode.getData();
				System.out.println("Appointment with tutor \"" + currApp.getTutor().getId() + "\": Topic: " + currApp.getTopic().getTopicName() + ", Hours: " + currApp.getHours() + ", Total Cost: $" + currApp.getTotalCost());
				totalCost += currApp.getTotalCost();
			}
			currNode = currNode.getNext();
		}
		System.out.println("Total number of hours of tutoring: " + super.getTotalHours() + "\nTotal cost of tutoring: $" + totalCost + "\n---------------------------------------------");
	}
	
	public void printData()
	{
		super.printNode();
		System.out.println();
	}
}
