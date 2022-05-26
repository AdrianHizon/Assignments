import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CommandsTest {

	@Test
	void testCreateStudent() {
		LinkedList studentList = new LinkedList();
		LinkedList tutorList = new LinkedList();
		Commands commands = new Commands(studentList, tutorList);
		
		assertTrue(commands.createStudent("testStudent1"));
		assertTrue(commands.createStudent("testStudent2"));
		assertTrue(commands.createStudent("testStudent3"));
		
		assertFalse(commands.createStudent("testStudent1"));
	}

	@Test
	void testCreateTutor() {
		LinkedList studentList = new LinkedList();
		LinkedList tutorList = new LinkedList();
		Commands commands = new Commands(studentList, tutorList);
		
		assertTrue(commands.createTutor("testTutor1", 30));
		assertTrue(commands.createTutor("testTutor3", 500));
		assertTrue(commands.createTutor("testTutor2", 2));
		
		assertFalse(commands.createTutor("testTutor1", 45));
	}

	@Test
	void testCreateTopic() {
		LinkedList studentList = new LinkedList();
		LinkedList tutorList = new LinkedList();
		Commands commands = new Commands(studentList, tutorList);
		
		commands.createTutor("testTutor", 100);
		
		assertTrue(commands.createTopic("testTutor", "testTopic1", 10));
		assertTrue(commands.createTopic("testTutor", "testTopic2", 40));
		assertTrue(commands.createTopic("testTutor", "testTopic3", 75));
		
		assertFalse(commands.createTopic("testTutor", "testTopic1", 80));
		assertFalse(commands.createTopic("fakeTutor", "testTopic4", 110));
	}

	@Test
	void testRequest() {
		LinkedList studentList = new LinkedList();
		LinkedList tutorList = new LinkedList();
		Commands commands = new Commands(studentList, tutorList);
		
		commands.createStudent("testStudent1");
		commands.createStudent("testStudent2");
		commands.createStudent("testStudent3");
		
		commands.createTutor("testTutor1", 50);
		commands.createTutor("testTutor2", 100);
		commands.createTutor("testTutor3", 2);
		commands.createTutor("testTutor4", 25);
		commands.createTutor("testTutor5", 25);
		
		commands.createTopic("testTutor1", "testTopic1", 10);
		commands.createTopic("testTutor2", "testTopic1", 10);
		commands.createTopic("testTutor3", "testTopic1", 100);
		commands.createTopic("testTutor4", "testTopic1", 50);
		commands.createTopic("testTutor5", "testTopic1", 25);
		
		assertTrue(commands.request("testStudent1", "testTopic1", 10));
		assertTrue(commands.request("testStudent2", "testTopic1", 20));
		assertTrue(commands.request("testStudent3", "testTopic1", 30));
		
		commands.studentReport("testStudent2");
		
		assertFalse(commands.request("fakeStudent", "testTopic1", 10));
		assertFalse(commands.request("testStudent1", "fakeTopic", 10));
		assertFalse(commands.request("testStudent1", "testTopic1", 0));
	}

	@Test
	void testStudentReport() {
		LinkedList studentList = new LinkedList();
		LinkedList tutorList = new LinkedList();
		Commands commands = new Commands(studentList, tutorList);
		
		commands.createStudent("testStudent1");
		commands.createStudent("testStudent2");
		
		commands.createTutor("testTutor1", 50);
		commands.createTutor("testTutor2", 100);
		
		commands.createTopic("testTopic1", "testTutor1", 10);
		commands.createTopic("testTopic1", "testTutor2", 10);
		
		commands.request("testStudent1", "testTopic1", 5);
		
		assertTrue(commands.studentReport("testStudent1"));
		assertTrue(commands.studentReport("testStudent2"));
		
		assertFalse(commands.studentReport("fakeStudent"));
	}

	@Test
	void testTutorReport() {
		LinkedList studentList = new LinkedList();
		LinkedList tutorList = new LinkedList();
		Commands commands = new Commands(studentList, tutorList);
		
		commands.createStudent("testStudent1");
		commands.createStudent("testStudent2");
		
		commands.createTutor("testTutor1", 50);
		commands.createTutor("testTutor2", 100);
		
		commands.createTopic("testTopic1", "testTutor1", 10);
		commands.createTopic("testTopic1", "testTutor2", 10);
		
		commands.request("testStudent1", "testTopic1", 5);
		
		assertTrue(commands.tutorReport("testTutor1"));
		assertTrue(commands.tutorReport("testTutor2"));
		
		assertFalse(commands.tutorReport("fakeTutor"));
	}

}
