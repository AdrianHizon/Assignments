import java.util.*;
import java.io.File;
import javax.swing.*;

public class A4HizonAdrian {

	public static void main(String[] args) {
		Table dictionary = new Table(Table.DICT_SIZE);
		dictionary.insertFile();
		Table incorrectTable = new Table(Table.INCORRECT_SIZE);
		incorrectTable.checkSpelling(dictionary);
		System.out.println(incorrectTable.incorrectTableToString());
	}
	
}

class Table{
	public static final int DICT_SIZE = 94321; //The table size of the dictionary table
	public static final int INCORRECT_SIZE = 2797; //The table size of the incorrect word table 
	private Node[] hashArray;
	private int tableSize;
	private int numWords;
	
	
	public Table(int tableSize) {
		hashArray = new Node[tableSize];
		this.tableSize = tableSize; 
		numWords = 0;
	}
	
	public int hash(String key) {
		int hashIndex = 0;
		int A = 13;
		String keyLowerCase = key.toLowerCase();
		for(int i= 0; i < keyLowerCase.length(); i++) {
			hashIndex = (hashIndex * A) + (int) keyLowerCase.charAt(i);
			hashIndex = hashIndex % tableSize;
		}
		return hashIndex;
	}
	
	public void insert(String key) {
		String keyLowerCase = key.toLowerCase();
		int hashIndex = hash(key);
		hashArray[hashIndex] = new Node(keyLowerCase, hashArray[hashIndex]);
		numWords++;
	}
	public void insertFile() {
		JFileChooser chooser = new JFileChooser(".");
		chooser.setDialogTitle("Choose .txt file to insert");
		chooser.showOpenDialog(null);
		File chosenFile = chooser.getSelectedFile();
		try {
			Scanner s = new Scanner(chosenFile);
			while(s.hasNext()) {
				insert(s.next());
			}
			s.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean search(String key) {
		String keyLowerCase = key.toLowerCase();
		boolean found = false;
		int hashIndex = hash(key);
		Node curr = hashArray[hashIndex];
		while(curr != null && !found) {
			found = curr.word.equals(keyLowerCase);
			curr = curr.next;
		}
		return found;
	}
	
	private class Node{
		private String word;
		private Node next;
		private Stack lines;
		
		public Node(String newWord, Node nextNode) {
			word = newWord;
			next = nextNode;
			lines = new Stack();
		}
	}
		
	public void insertIncorrect(String key, int lineNumber) {//, Table dictionary) {
		String keyLowerCase = key.toLowerCase();
		int hashIndex = hash(key);
		Node newNode;
		if(search(key)) {
			Node curr = hashArray[hashIndex];
			while(!curr.word.equals(keyLowerCase) && curr != null) {
				curr = curr.next;
			}
			curr.lines.push(lineNumber);
		}
		else {
			newNode = new Node(keyLowerCase, hashArray[hashIndex]);
			newNode.lines.push(lineNumber);
			hashArray[hashIndex] = newNode;
			numWords++;
		}
	}
		
	public void checkSpelling(Table dictionary) {
		JFileChooser chooser = new JFileChooser(".");
		chooser.setDialogTitle("Choose .txt file to check for spelling errors");
		chooser.showOpenDialog(null);
		File chosenFile = chooser.getSelectedFile();
		try {
			Scanner s = new Scanner(chosenFile);
			int numLines = 0;
			while(s.hasNextLine()) {
				numLines++;
				String nextLine = s.nextLine();
				String nextWord;
				String[] nextLineSplit = nextLine.trim().split("[^a-zA-Z']+");
				for(int i = 0; i < nextLineSplit.length; i++) {
					if(nextLineSplit[i].length() != 0) {
						nextWord = nextLineSplit[i];
						if(!dictionary.search(nextWord)) {
							insertIncorrect(nextWord, numLines);
						}
					}
				}
			}
			s.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		
	public String incorrectTableToString() {
		String s = "";
		for(int i = 0; i < hashArray.length; i++) {
			if(hashArray[i] != null) {
				Node curr = hashArray[i];
				while(curr != null) {
					s += "Invalid word \"" + curr.word + "\" found on lines ";
					while(!curr.lines.isEmpty()) {
						s += curr.lines.pop() + " ";
					}
					s += "\n";
					curr = curr.next;
				}
			}
		}
		s += "\nTotal number of incorrect words: " + numWords;
		return s;
	}

	private class Stack{
		
		private Node top;
		
		public Stack() {
			top = null;
		}
		
		public void push(int lineNumber) {
			if(top == null) {
				top = new Node("" + lineNumber, null);
			}
			else {
				top = new Node("" + lineNumber, top);
			}
		}
		
		public String pop() {
			String lineNumber = top.word;
			top = top.next;
			return lineNumber;
		}

		public String top() {
			return top.word;
		}
		
		public boolean isEmpty() {
			return top == null;
		}
	}

}

