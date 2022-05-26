// CLASS: Topic
//
// Author: Adrian Hizon, 7867173
//
// PURPOSE: A topic that is taught by a tutor.
//
//-----------------------------------------

public class Topic extends NodeData
{
	private String topicName;
	private int cost;
	
	public Topic(String topicName, int cost) {
		this.topicName = topicName;
		this.cost = cost;
	}
	
	public String getTopicName()
	{
		return topicName;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public void printData()
	{
		System.out.println("Topic name: " + topicName + ", Cost: " + cost);
	}
	
}
