// CLASS: User
//
// Author: Adrian Hizon, 7867173
//
// PURPOSE: A user in the system
//
//-----------------------------------------

public abstract class User extends NodeData 
{
	private String userId;
	private int totalHours;
	private LinkedList appointmentList;
	
	public User(String id)
	{
		super();
		this.userId = id;
		totalHours = 0;
		appointmentList = new LinkedList();
	}
	
	public String getId()
	{
		return userId;
	}
	
	public int getTotalHours()
	{
		return totalHours;
	}
	
	public void addHours(int hours)
	{
		totalHours += hours;
	}
	
	public LinkedList getAppList()
	{
		return appointmentList;
	}
	
	public void printNode()
	{
		System.out.println("User ID: " + userId);
		appointmentList.printList();
		System.out.println("Total hours: " + totalHours);
	}
	
	abstract public void report();
}
