 //-----------------------------------------
 // NAME			: Adrian Hizon 
 // STUDENT NUMBER	: 7867173
 // COURSE			: COMP 2150
 // INSTRUCTOR		: Dr. Ali Neshati
 // ASSIGNMENT		: Assignment 1    
 // 
 // PURPOSE: Create a system where users can register as
 //          a tutor or a student. Students can then request tutoring
 //          and will have tutors be automatically assigned to them.
 //-----------------------------------------

public class Main 
{
	public static void main(String args[]) {
		
		LinkedList studentList = new LinkedList();
		LinkedList tutorList = new LinkedList();
		Commands commands = new Commands(studentList, tutorList);
		
		commands.readFile();
		
		System.out.println("End of program.");
	}
}
