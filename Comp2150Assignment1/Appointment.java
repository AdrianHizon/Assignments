// CLASS: Appointment
//
// Author: Adrian Hizon, 7867173
//
// PURPOSE: An appointment between a student and tutor.
//
//-----------------------------------------

public class Appointment extends NodeData
{
	private Student student;
	private Tutor tutor;
	private Topic topic;
	private int hours;
	
	public Appointment(Student student, Tutor tutor, Topic topic)
	{
		this.student = student;
		this.tutor = tutor;
		this.topic = topic;
		this.hours = 0;
	}
	
	public Student getStudent()
	{
		return student;
	}
	
	public Tutor getTutor()
	{
		return tutor;
	}
	
	public Topic getTopic()
	{
		return topic;
	}
	
	public int getHours()
	{
		return hours;
	}
	
	public int getTotalCost()
	{
		int totalCost = topic.getCost() * hours;
		return totalCost;
	}
	
	public void addHours(int hours)
	{
		this.hours += hours;
	}
	
	//------------------------------------------------------
    // finalizeAppointment
    //
    // PURPOSE: Finalizes an appointment by adding it to the appointment lists of its student and tutor
    //------------------------------------------------------
	
	public void finalizeAppointment()
	{
		System.out.println("Tutor \"" + tutor.getId() + "\" will tutor student \"" + student.getId() + " for " + hours + " in topic \"" + topic.getTopicName() + " at a rate of $" + topic.getCost());
		student.addHours(hours); 
		student.getAppList().insertNode(this); 
		tutor.addHours(hours); 
		tutor.getAppList().insertNode(this);
	}
	
	public void printData()
	{
		System.out.println("Student: " + student.getId() + ", Tutor: " + tutor.getId() + ", Topic: " + topic.getTopicName() + ", Hours: " + hours + ".");
	}
}
