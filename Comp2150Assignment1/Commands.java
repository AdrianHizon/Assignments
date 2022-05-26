// CLASS: Commands
//
// Author: Adrian Hizon, 7867173
//
// PURPOSE: Commands that are used to create, manage, and modify the student-tutor system.
//
//-----------------------------------------

import java.util.*;
import java.io.*;

public class Commands 
{
	private LinkedList studentList;
	private LinkedList tutorList;
	
	public Commands(LinkedList studentList, LinkedList tutorList)
	{
		this.studentList = studentList;
		this.tutorList = tutorList;
	}
	
	//------------------------------------------------------
    // readFile
    //
    // PURPOSE: Reads a text file to process the commands written in it
    //------------------------------------------------------
	public void readFile()
	{
		try
		{
			Scanner s = new Scanner(System.in);
			System.out.println("Trying to open file.\nEnter filename: ");
			String fileName = s.nextLine();
			BufferedReader br = new BufferedReader(new FileReader(fileName)); 
			boolean quit = false;
			String line = br.readLine();
			StringTokenizer sToken;
			while(line != null && quit == false)
			{
				sToken = new StringTokenizer(line, " ");
				String token;
				token = sToken.nextToken();
				
				if(token.compareTo("#") != 0)
				{
					if(token.compareTo("QUIT") == 0)
					{
						quit = true;
						System.out.println("Successfully quit program from QUIT command.");
					}
					else if(token.compareTo("TUTOR") == 0)
					{
						String userId = sToken.nextToken();
						int hours = Integer.parseInt(sToken.nextToken());
						createTutor(userId, hours);
					}
					else if(token.compareTo("STUDENT") == 0)
					{
						String userId = sToken.nextToken();
						createStudent(userId);
					}
					else if(token.compareTo("TOPIC") == 0)
					{
						String topicName = sToken.nextToken();
						String tutorId = sToken.nextToken();
						int price = Integer.parseInt(sToken.nextToken());
						createTopic(tutorId, topicName, price);
					}
					else if(token.compareTo("REQUEST") == 0)
					{
						String studentId = sToken.nextToken();
						String topic = sToken.nextToken();
						int hours = Integer.parseInt(sToken.nextToken());
						request(studentId, topic, hours);
					}
					else if(token.compareTo("STUDENTREPORT") == 0)
					{
						String studentId = sToken.nextToken();
						studentReport(studentId);
					}
					else if(token.compareTo("TUTORREPORT") == 0)
					{
						String tutorId = sToken.nextToken();
						tutorReport(tutorId);
					}
					else
					{
						System.out.println("Invalid command read.");
					}
				}
					
				line = br.readLine();
			}
			if(quit == false)
			{
				System.out.println("Program terminated without QUIT command");
			}
			br.close();
			s.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//------------------------------------------------------
    // createStudent
    //
    // PURPOSE: Creates a student and adds it to the list of students
    // PARAMETERS: Receives a string that is the user ID of the student
    // Returns: Returns true on success and false if the user ID is a duplicate
    //------------------------------------------------------
	public boolean createStudent(String id)
	{
		boolean created = false;
		Student newStudent = new Student(id);
		User duplicate = findUser(id, studentList);
		if(duplicate == null)
		{
			studentList.insertNode(newStudent);
			System.out.println("Successfully added student with user id \"" + id + "\".");
			created = true;
		}
		else
		{
			System.out.println("Failed while trying to add duplicate student with user id \"" + id + "\".");
		}
		return created;
	}
	
	//------------------------------------------------------
    // createTutor
    //
    // PURPOSE: Creates a tutor and adds it to the list of tutors
    // PARAMETERS: Receives a string that is the user ID of the tutor
    // Returns: Returns true on success and false if the user ID is a duplicate
    //------------------------------------------------------
	public boolean createTutor(String id, int hours)
	{
		boolean created = false;
		Tutor newTutor = new Tutor(id, hours);
		User duplicate = findUser(id, tutorList);
		if(duplicate == null)
		{
			tutorList.insertNode(newTutor);
			System.out.println("Successfully added tutor with user id \"" + id + "\" and total hours: " + newTutor.getMaxHours() + ".");
			created = true;
		}
		else
		{
			System.out.println("Failed while trying to add duplicate tutor with user id \"" + id + "\".");
		}
		return created;
	}
	
	//------------------------------------------------------
    // createTopic
    //
    // PURPOSE: Creates a topic and adds it to a given tutor's list of topics
    // PARAMETERS: Receives strings corresponding to the user ID of the tutor
	//             and the name of the topic, also receives an integer that is
	//             the tutor's price for the topic.
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean createTopic(String tutorId, String topicName, int price)
	{
		boolean created = false;
		User tutor = findUser(tutorId, tutorList);
		//Topic newTopic = new Topic(topicName, price);
		if(tutor != null)
		{
			if(tutor instanceof Tutor)
			{
				created = ((Tutor)tutor).addTopic(topicName, price);
			}
		}
		else
		{
			System.out.println("Failed while trying to add a topic to nonexistent tutor with user id \"" + tutorId +"\"");
		}
		return created;
	}
	
	//------------------------------------------------------
    // request
    //
    // PURPOSE: Creates a tutoring appointment between a student and 1 or more tutors
    // PARAMETERS: Receives strings corresponding to the user ID of the student
	//             and the name of the topic, also receives an integer that is
	//             the amount of hours of tutoring the student wants
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean request(String studentId, String topicName, int hours)
	{
		boolean success = false;
		User requester = findUser(studentId, studentList);
		int allottedHours = 0;
		LinkedList possibleAppointments = new LinkedList();
		LinkedList finalAppointments = new LinkedList();
		Node currNode = tutorList.getTop();
		Topic currTopic;
		Appointment possibleApp;
		Appointment bestApp;
		Appointment currApp;
		int availableHours;
		int remainingHours;
		
		if(hours > 0)
		{
			if(requester != null)
			{
				System.out.println("Attempting to fulfill request for \"" + requester.getId() + "\" to receive " + hours + " hours of tutoring in topic \"" + topicName + "\".");
				while(currNode != null)
				{
					if(currNode.getData() instanceof Tutor && requester instanceof Student)
					{
						currTopic = ((Tutor)currNode.getData()).findTopic(topicName);
						if(currTopic != null)
						{
							possibleApp = new Appointment((Student)requester, (Tutor)currNode.getData(), currTopic);
							possibleAppointments.insertNode(possibleApp);
						}
					}
					currNode = currNode.getNext();
				}	
				while(allottedHours < hours && possibleAppointments.getTop() != null && possibleAppointments.getTop().getData() instanceof Appointment)
				{
					currNode = possibleAppointments.getTop();
					bestApp = (Appointment)currNode.getData();
					while(currNode != null)
					{
						if(currNode.getData() instanceof Appointment)
						{
							currApp = (Appointment)currNode.getData();
							if(currApp.getTopic().getCost() == bestApp.getTopic().getCost())
							{
								if(currApp.getTutor().getAvailableHours() == bestApp.getTutor().getAvailableHours())
								{
									if(currApp.getTutor().getId().compareTo(bestApp.getTutor().getId()) < 0)
									{
										bestApp = currApp;
									}
								}
								else if(currApp.getTutor().getAvailableHours() > bestApp.getTutor().getAvailableHours())
								{
									bestApp = currApp;
								}
							}
							else if(currApp.getTopic().getCost() < bestApp.getTopic().getCost())
							{
								bestApp = currApp;
							}
						}
						currNode = currNode.getNext();
					}
					
					availableHours = bestApp.getTutor().getAvailableHours();
					remainingHours = hours - allottedHours;
					if(availableHours > 0)
					{
						if(remainingHours <= availableHours)
						{
							bestApp.addHours(remainingHours);
							allottedHours += remainingHours;
						}
						else
						{
							bestApp.addHours(availableHours);
							allottedHours += availableHours;
						}
						
						finalAppointments.insertNode(bestApp);
					}
					possibleAppointments.deleteNode(bestApp);
				}
				if(allottedHours == hours)
				{
					currNode = finalAppointments.getTop();
					while(currNode != null)
					{
						if(currNode.getData() instanceof Appointment)
						{
							((Appointment)currNode.getData()).finalizeAppointment();
						}
						currNode = currNode.getNext();
					}
					success = true;
				}
				else
				{
					System.out.println("Failed to appoint " + hours + " hours in topic \"" + topicName + "\" for student with user id \"" + studentId + "\"." );
				}
				
			}
			else
			{
				System.out.println("Failed request from nonexistent student with user id \"" + studentId + "\"");
			}
		}
		else
		{
			System.out.println("Failed to appoint " + hours + " hours in topic \"" + topicName + "\" for student with user id \"" + studentId + "\"." );
		}
		
		return success;
	}
	
	//------------------------------------------------------
    // studentReport
    //
    // PURPOSE: Prints out a report of a student
    // PARAMETERS: Receives a string that is the student's user ID
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean studentReport(String userId)
	{
		boolean success = false;
		User report = findUser(userId, studentList);
		if(report != null)
		{
			success = true;
			report.report();
		}
		else
		{
			System.out.println("Failed while trying to print report of nonexistent student with user id \"" + userId + "\".");
		}
		return success;
	}
	
	//------------------------------------------------------
    // tutorReport
    //
    // PURPOSE: Prints out a report of a tutor
    // PARAMETERS: Receives a string that is the tutor's user ID
    // Returns: Returns true on success and false on failure
    //------------------------------------------------------
	public boolean tutorReport(String userId)
	{
		boolean success = false;
		User report = findUser(userId, tutorList);
		if(report != null)
		{
			success = true;
			report.report();
		}
		else
		{
			System.out.println("Failed while trying to print report of nonexistent tutor with user id \"" + userId + "\".");
		}
		return success;
	}
	
	//------------------------------------------------------
    // findUser
    //
    // PURPOSE: Searches for a given user in a given list
    // PARAMETERS: Receives a string that is the ID of the user
	//             and the list to search in
    // Returns: Returns the user if found and null if not found
    //------------------------------------------------------
	private User findUser(String id, LinkedList userList)
	{
		Node currNode = userList.getTop();
		User targetUser = null;
		while(currNode != null)
		{
			if(currNode.getData() instanceof User && ((User)currNode.getData()).getId().compareTo(id) == 0)
			{
				targetUser = (User)currNode.getData();
			}
			currNode = currNode.getNext();
		}
		return targetUser;
	}
}
