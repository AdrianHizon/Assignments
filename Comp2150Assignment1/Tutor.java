// CLASS: Tutor
//
// Author: Adrian Hizon, 7867173
//
// PURPOSE: A user that is a tutor.
//
//-----------------------------------------

public class Tutor extends User
{
	private int maxHours;
	private LinkedList topicList;
	
	public Tutor(String id, int hours)
	{
		super(id);
		this.maxHours = hours;
		topicList = new LinkedList();
	}
	
	public int getMaxHours()
	{
		return maxHours;
	}
	
	public int getAvailableHours()
	{
		return maxHours - super.getTotalHours();
	}
	
	public LinkedList getTopicList()
	{
		return topicList;
	}
	
	//------------------------------------------------------
    // report
    //
    // PURPOSE: Prints a report of the tutor
    //------------------------------------------------------
	public void report()
	{
		int totalCost = 0;
		System.out.println("\nReport for tutor \"" + super.getId() + "\"\n---------------------------------------------");
		Node currNode = super.getAppList().getTop();
		Appointment currApp;
		while(currNode != null)
		{
			if(currNode.getData() instanceof Appointment)
			{
				currApp = (Appointment)currNode.getData();
				System.out.println("Appointment with student \"" + currApp.getStudent().getId() + "\": Topic: " + currApp.getTopic().getTopicName() + ", Hours: " + currApp.getHours() + ", Total Revenue: $" + currApp.getTotalCost());
				totalCost += currApp.getTotalCost();
			}
			currNode = currNode.getNext();
		}
		System.out.println("Total number of hours of tutoring: " + super.getTotalHours() + "\nTotal revenue from tutoring: $" + totalCost + "\n---------------------------------------------");
	}
	
	//------------------------------------------------------
    // addTopic
    //
    // PURPOSE: Adds a topic to the tutor's list of topics
    // PARAMETERS: Receives a string for the name of the topic and 
	//             integer for the price of the topic
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean addTopic(String topicName, int price)
	{
		boolean added = false;
		Topic newTopic = new Topic(topicName, price);
		Topic duplicate = findTopic(topicName);
		
		if(duplicate == null)
		{
			topicList.insertNode(newTopic);
			added = true;
			System.out.println("Successfully added topic \"" + topicName + "\" to tutor with user id \"" + super.getId() + "\" with price of $" + price + ".");
		}
		else
		{
			System.out.println("Failed while trying to add duplicate topic \"" + topicName + "\" to tutor with user id \"" + super.getId() + "\"");
		}
		
		return added;
	}
	
	//------------------------------------------------------
    // findTopic
    //
    // PURPOSE: Searches for a topic inside the tutor's list of topics
    // PARAMETERS: Receives a string that is the name of the topic
    // Returns: Return the topic if found and null if not found
    //------------------------------------------------------
	public Topic findTopic(String topicName)
	{
		Topic targetTopic = null;
		Node currNode = topicList.getTop();
		while(currNode != null)
			{
				if(currNode.getData() instanceof Topic && ((Topic)currNode.getData()).getTopicName().compareTo(topicName) == 0)
				{
					targetTopic = (Topic)currNode.getData();
				}
				currNode = currNode.getNext();
			}
		
		return targetTopic;
	}
	
	public void printData()
	{
		super.printNode();
		System.out.println("Max Hours: " + maxHours);
		topicList.printList();
		System.out.println();
	}
}
