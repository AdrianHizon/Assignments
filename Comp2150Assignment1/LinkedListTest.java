import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testInsertNode() {
		LinkedList list = new LinkedList();
		User testStudent = new Student("test");
		User testTutor = new Tutor("test", 0);
		Topic testTopic = new Topic("test", 0);
		Appointment testApp = null;
		if(testStudent instanceof Student && testTutor instanceof Tutor) {
			testApp = new Appointment((Student)testStudent, (Tutor)testTutor, testTopic);
		}
		
		assertTrue(list.insertNode(testStudent));
		assertEquals(1, list.getNodeCount());
		
		assertTrue(list.insertNode(testTutor));
		assertEquals(2, list.getNodeCount());
		
		assertTrue(list.insertNode(testTopic));
		assertEquals(3, list.getNodeCount());
		
		assertTrue(list.insertNode(testApp));
		assertEquals(4, list.getNodeCount());
		
		assertFalse(list.insertNode(null));
		assertEquals(4, list.getNodeCount());
	}
	
	@Test
	public void testGetTop() {
		LinkedList list = new LinkedList();
		
		assertNull(list.getTop());
		
		User dummyStudent = new Student("dummy");
		list.insertNode(dummyStudent);
		assertNotNull(list.getTop());
	}

	@Test
	public void testDeleteNode() {
		LinkedList list = new LinkedList();
		User testStudent1 = new Student("testStudent1");
		User testStudent2 = new Student("testStudent2");
		User testStudent3 = new Student("testStudent3");
		User testTutor1 = new Tutor("testTutor1", 10);
		User testTutor2 = new Tutor("testTutor3", 20);
		User testTutor3 = new Tutor("testTutor2", 30);
		
		list.insertNode(testTutor1);
		list.insertNode(testTutor2);
		list.insertNode(testTutor3);
		list.insertNode(testStudent1);
		list.insertNode(testStudent2);
		list.insertNode(testStudent3);
		
		assertTrue(list.deleteNode(testTutor1));
		assertTrue(list.deleteNode(testStudent3));
		assertTrue(list.deleteNode(testTutor3));
		assertTrue(list.deleteNode(testStudent1));
		
		assertFalse(list.deleteNode(testStudent1));
		assertFalse(list.deleteNode(null));
	}
	
	@Test
	public void testDeleteFirst() {
		LinkedList list = new LinkedList();
		User testStudent1 = new Student("testStudent1");
		User testStudent2 = new Student("testStudent2");
		User testTutor1 = new Tutor("testTutor1", 10);
		list.insertNode(testStudent1);
		list.insertNode(testStudent2);
		list.insertNode(testTutor1);
		
		assertTrue(list.deleteFirst());
		assertEquals(2, list.getNodeCount());
		assertTrue(list.deleteFirst());
		assertEquals(1, list.getNodeCount());
		assertTrue(list.deleteFirst());
		assertEquals(0, list.getNodeCount());
		assertFalse(list.deleteFirst());
	}
	
	@Test
	public void testDeleteLast() {
		LinkedList list = new LinkedList();
		User testStudent1 = new Student("testStudent1");
		User testStudent2 = new Student("testStudent2");
		User testTutor1 = new Tutor("testTutor1", 10);
		list.insertNode(testStudent1);
		list.insertNode(testStudent2);
		list.insertNode(testTutor1);
		
		assertTrue(list.deleteFirst());
		assertEquals(2, list.getNodeCount());
		assertTrue(list.deleteFirst());
		assertEquals(1, list.getNodeCount());
		assertTrue(list.deleteFirst());
		assertEquals(0, list.getNodeCount());
		assertFalse(list.deleteFirst());
	}
}
