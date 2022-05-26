// PURPOSE: This file implements a queue using the generic type <E>. 
//

public class MyQueue<E> {

	// INSTANCE VARIABLES 
  
     //write code here
	protected MyStack<E> stack1;
	protected MyStack<E> stack2;
	// CONSTRUCTOR

	public MyQueue() { 

	    //write code here
		stack1 = new MyStack<E>();
		stack2 = new MyStack<E>();
	}

	// ACCESSOR METHODS
   
	// METHOD: isEmpty
	// PURPOSE: Return true if the queue is empty.
	public boolean isEmpty() { 
		 //is empty
		return stack1.isEmpty() && stack2.isEmpty();
	}
    
	// ACTION METHODS

	// METHOD: transferStacks
	// PURPOSE: Move the content from stack1 to stack2 such that its
	// order on stack2 is reverse from what it was on stack1.
	protected void transferStacks() {
		 //write code here
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}
	
	// METHOD: enqueue
	// PURPOSE: Add elem to the front of the queue.
	public void enqueue(E elem) {
	        //write code here
		stack1.push(elem);
	}

	// METHOD: dequeue
	// PURPOSE: Return the element at the front of the queue and remove
	// it from the queue.
	public E dequeue() throws EmptyStackQueueException {
		 //write code here
		E result = null;
		if(stack2.isEmpty()) {
			transferStacks();
		}
		result = stack2.pop();
		return result;
	}
}


