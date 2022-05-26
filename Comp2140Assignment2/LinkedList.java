//e1073. Do not delete this line
import java.util.*;

/******************************************
 *
 * LinkedList: A circular (singly-linked)
 * list with a last pointer and the number
 * of nodes.
 *
 ******************************************/

public class LinkedList
{
    public class Node
    {
        public int item;
        public Node next;

        public Node( int newItem, Node newNext )
        {
            item = newItem;
            next = newNext;
        }
    }


    private Node last;
    private int nodeCount;
    private static Random generator = new Random(System.nanoTime());

    public LinkedList()
    {
        last = null;
        nodeCount = 0;
    }

    public int getSize()
    {
        return nodeCount;
    }

    /*******************************************
     *
     *  insertNode: Insert a given node, newNode,
     *  into the list.  Since the list is
     *  unordered and inserting at the front of
     *  the list is easiest, we'll insert there.
     *
     *  Only special case: If the list is empty.
     *
     ********************************************/
    private void insertNode( Node newNode )
    {
        if ( nodeCount == 0 )
        {
            newNode.next = newNode;
            last = newNode;
        }
        else
        {
            newNode.next = last.next;
            last.next = newNode;
        }
        nodeCount++;
    }


    /*******************************************
     *
     *  insertValue: Insert a given item, newItem,
     *  into the list.  Since the list is
     *  unordered and inserting at the front of
     *  the list is easiest, we'll insert there.
     *
     *  Only special case: If the list is empty.
     *
     ********************************************/
    void insertValue(int newItem)
    {
        Node newNode = new Node( newItem, null );
        if ( nodeCount == 0 )
        {
            newNode.next = newNode;
            last = newNode;
        }
        else
        {
            newNode.next = last.next;
            last.next = newNode;
        }
        nodeCount++;
    }
    /*
    corrupt: expects an ordinary linked list with a null pointer in the last node.
    The latest inserted node sits at index 0.
    Take the last node in the linked list and change its pointer to the node at the given index.
    return the value of the corruption index.
     */
    public int corrupt(int index) {
        int valOfCorruptedNode=Integer.MIN_VALUE;
        //write your code here
        Node curr = last;
        Node corruptNode;
        for(int i = 0; i < index; i++) {
        	curr = curr.next;
        }
        corruptNode = curr;
        valOfCorruptedNode = corruptNode.item;
        while(curr.next != null) {
        	curr = curr.next;
        }
        curr.next = corruptNode;
        return valOfCorruptedNode;
    }//end of corrupt

    /*
    findCorruption: find if the linked list contains a loop.
    Corruption is defined as the last node not having a null pointer, but instead pointing to a node in the linked
    list as its forward node. A circular link is due to a corruption.
    Do not use the sorted order of the linked list to detect the corruption.
    A popular interview question, the solution to this question is known as the Floyd’s Cycle-Finding Algorithm.
    A more difficult version would ask the index/value of the corruption.
     */
    public boolean findCorruption() {
        //write your code here

        // Do not store visited nodes to detect a loop.
        // Because if the linkedlist is big, you would store too much information.
    	boolean loop = false;
    	Node curr = last;
    	Node currDouble = last;
    	do {
    		curr = curr.next;
    		currDouble = currDouble.next.next;
    		if(curr == currDouble) {
    			loop = true;
    		}
    	}
    	while(curr != null && currDouble != null && currDouble.next != null && curr != currDouble);
    	return loop;
    }//end of findCorruption
    /*
    reset: Remove every node from the linked list. Do not forget the nodeCount variable.
     */
    public void reset() {
        //write your code here.
    	nodeCount = 0;
    	last = null;
    }// end of reset

    /*
    deleteOddNodes: delete nodes that have an odd item value.
    Reassign pointers. Do not create a new linked list.
     */
    public void deleteOddNodes() {
        //write your code here
    	Node curr = last;
    	Node prev = curr;
    	while(curr != null) {
    		if((curr.item % 2) == 1) {
    			if(curr == last) {
    				last = last.next;
    				nodeCount--;
    			}
    			else {
    				prev.next = curr.next;
    				curr = prev;
    				nodeCount--;
    			}
    		}
    		prev = curr;
    		curr = curr.next;
    	}
    }//end of deleteOddNotes
    /*
    hasDummies: checks if the linked list has 1) a dummy header with Integer.MIN_VALUE
    and a dummy trailer with  Integer.MAX_VALUE.
     */

    public boolean hasDummies() {
        //write your code here
        //change return type yourself
//    	boolean dummies = false;
//    	dummies = (last.item == Integer.MAX_VALUE) && (last.next.item == Integer.MIN_VALUE);
//    	Node trailer;
    	Node curr = last;
    	while(curr.next != null) {
    		curr = curr.next;
    	}
    	return (last.item == Integer.MIN_VALUE) && (curr.item == Integer.MAX_VALUE);
    }//end of hasDummies
    /*
    isOrdinary: checks the type of this list.
    If the list is in a given type, it returns true, otherwise false.
    if the list empty, return false.
    Use the nodecount variable to detect the end
     */
    public boolean isOrdinary( ) {
        //write your code here
        //change return type yourself
    	boolean ordinary = false;
    	if(nodeCount != 0) {
	    	Node curr = last;
	        for(int i = 1; i < nodeCount; i ++) {
	    		curr = curr.next;
	    	}
	        ordinary = curr.next == null;
    	}
        return ordinary;
    }//end of isOrdinary
    /*
   isCircular: checks the type of this list.
   If the list is circular, it returns true, otherwise false.
   if the list empty, return false.
   Use the nodeCount variable to detect the end

    */
    public boolean isCircular( ) {
        //write your code here
        //change return type yourself
    	boolean circular = false;
    	if(nodeCount != 0) {
	    	Node curr = last;
	    	for(int i = 1; i < nodeCount; i ++) {
	    		curr = curr.next;
	    	}
	    	circular = curr.next != null;
    	}
        return circular;
    }//end of isCircular
    
    /*
    addDummies: add a dummy header and a dummy trailer to the linked list.
    Use Integer.MIN_VALUE and Integer.MAX_VALUE
     */
    public void addDummies() {
        // write your code here
//    	Node first = last.next;
//    	Node header; //= new Node(Integer.MIN_VALUE, last.next);
//    	Node trailer; //= new Node(Integer.MAX_VALUE, header);
//    	if(this.isCircular()) {
//    		Node header = new Node(Integer.MIN_VALUE, last.next);
//    		Node trailer = new Node(Integer.MAX_VALUE, header);
//	    	last.next = trailer;
//	    	last = trailer;
//	    	nodeCount += 2;
//    	}
//    	else if(this.isOrdinary()) {
		Node curr = last;
		while(curr.next != null) {
			curr = curr.next;
		}
		last = new Node(Integer.MIN_VALUE, last);
		curr.next = new Node(Integer.MAX_VALUE, null);
		nodeCount += 2; //Increments nodeCount so isOrdinary() and isCircular() still function.
//    	}
    }//end of addDummies
    /***********************************************
     *
     * convertCircularToOrdinary:  Convert the list to an ordinary
     * linked list (a single linked list without dummy header or trailer).
     * use the existing last pointer and rewrite
     * its address to point to the first node. Update the last node's forward pointer as well.
     * This linked list class is originally written for a circular linked list,
     * DO NOT CHANGE THE ORIGINAL INSERT OR DELETE METHODS.
     ************************************************/
    public void convertCircularToOrdinary() {

        //write your code here
    	Node first = last.next;
    	last.next = null;
    	last = first;
    }//end of convertCircularToOrdinary

    /***********************************************
     * convertOrdinaryToCircular:  Convert the list to a circular
     * linked list (without a dummy header or trailer).
     ************************************************/
    public void convertOrdinaryToCircular() {

        //write your code here
    	Node first = last;
    	Node curr = last;
    	while(curr.next != null) {
    		curr = curr.next;
    	}
    	curr.next = first;
    	last = curr;
    }//end of convertOrdinaryToCircular


    /***********************************************
     *
     * add:  Take the values in the parameter list2 test test test test test
     * and insert them into this list in an order-preserving manner (keep the order as it is in list1).
     * The list2 should not change. Both lists are circular single linked lists (no dummies)
     *
     ************************************************/
    public void add(LinkedList list2) {
        //write your code here. List1 and list2 can contain duplicate values.
    	Node list2Curr = list2.last;
    	do {
    		list2Curr = list2Curr.next;
    		this.insertOrdered(list2Curr.item);
    	}
    	while(list2Curr != list2.last);
    }//end of add

    private void insertOrdered(int newItem) {
    	Node curr = last;
    	Node prev;
    	if(nodeCount != 0) {
	    	do {
	    		prev = curr;
	    		curr = curr.next;
	    	}
	    	while(curr != last && curr.item < newItem);
	    	if(curr != last || curr.item > newItem) {
	    		prev.next = new Node(newItem, curr);
	    	}
	    	else {
	    		last = new Node(newItem, last.next);
	    		curr.next = last;
	    	}
    	}
    	else {
    		last = new Node(newItem, null);
    		last.next = last;
    	}
    	nodeCount++;
    }

    /***********************************************
     *
     *  choosePivot:  Randomly choose a pivot from
     *  the list, unlink it from the list and return
     *  a pointer to it.
     *
     *  Assuming that the first node (last.next) is
     *  in position 0 and the last node is in
     *  position nodeCount-1, choose a random
     *  number, randomIndex, in the range 0 to
     *  nodeCount-1, and unlink the node in position
     *  randomIndex to be the pivot.
     *
     ************************************************/

    private Node choosePivot( )
    {
        int randomIndex = generator.nextInt( nodeCount );
        Node prev = last;
        Node pivot;
        int i;

        // Find the node before the pivot
        for ( i = 0; i <= randomIndex; i++ )
            prev = prev.next;

        pivot = prev.next;
        if ( last == pivot )
            last = prev;
        prev.next = pivot.next;
        nodeCount--;

        return pivot;
    } // end choosePivot


    /*******************************************
     *
     *  partition: Given a node, pivot (not in the
     *  list), leave all the nodes containing items
     *  >= the pivot's item in the list and move
     *  all nodes containing items < the pivot's item
     *  into a new LinkedList.  That is, at the end,
     *  the bigs remain in the list and the smalls
     *  are moved into a new list (which is returned).
     *
     *  Create two LinkedLists smalls and bigs.
     *  Move each node in the calling LinkedList
     *  into the smalls or the bigs list (compare
     *  each node's item to pivot.item and then
     *  unlink it from the calling list and
     *  use method insertNode() to put it into
     *  the smalls or bigs).
     *
     *  No Nodes should be created or destroyed by
     *  this method, and no item in a Node should
     *  be changed by this method.  This method
     *  simply unlinks and links existing nodes.
     *
     *********************************************/

    public LinkedList partition( Node pivot )
    {
        Node curr;
        LinkedList smalls = new LinkedList();
        LinkedList bigs = new LinkedList();
        int size = nodeCount;
        int i;

        for ( i = 0; i < size; i++ )
        {
            curr = last.next;
            last.next = last.next.next;
            nodeCount--;
            if ( curr.item < pivot.item )
            {
                // curr belongs in the smalls

                smalls.insertNode( curr );
            }
            else
            {
                // curr belongs in the bigs.

                bigs.insertNode( curr );
            }
        }
        last = bigs.last;
        nodeCount = bigs.nodeCount;

        return smalls;
    } // end partition

    /***********************************************
     *
     *  rejoin: Given the sorted smalls list and
     *  a pointer to the pivot, relink into the
     *  sorted list (which contains the sorted bigs)
     *  into the correct positions.
     *
     ************************************************/

    private void rejoin( LinkedList smalls, Node pivot )
    {
        Node firstBig;

        smalls.insertNode( pivot ); // insert pivot at front
        smalls.last = smalls.last.next; // pivot should be last node
        if ( nodeCount != 0 )
        {
            // There are some bigs.

            firstBig = this.last.next;
            this.last.next = smalls.last.next;
            pivot.next = firstBig;
            nodeCount = nodeCount + smalls.nodeCount;
        }
        else
        {
            // There are no bigs.

            this.last = smalls.last;
            nodeCount = smalls.nodeCount;
        }

    } // end rejoin

    /***********************************
     *
     * quickSort: Recursively quick sort a
     *    a circular linked list with no
     *    dummy nodes.
     *
     *   (Since the partition method
     *   puts the smalls into a new
     *   circular linked list, after the
     *   recursive calls, the smalls must
     *   be joined back into the list.)
     *
     **************************************/
    public void quickSort( )
    {
        Node pivot;
        LinkedList smalls;

        if ( nodeCount > 2 )
        {
            pivot = choosePivot(); // removes a pivot
            smalls = partition( pivot ); // bigs in original list
            smalls.quickSort(  );
            quickSort( ); // recursively quick sort the bigs
            rejoin( smalls, pivot ); // rejoin into one circular list
        }
        if ( nodeCount == 2 )
        {
            if ( last.item < last.next.item )
            {
                // swap them: first becomes last
                last = last.next;
            }
        }
        // else do nothing for nodeCount 0 or 1
    } // end quickSort

    /***********************************
     *
     * isSorted: Returns true if the list
     *  is sorted, false otherwise.
     *
     **************************************/

    public boolean isSorted()
    {
        boolean sorted = true;
        Node curr = last.next;

        if ( nodeCount > 1 )
        {
            do
            {
                if ( curr.next.item < curr.item )
                    sorted = false;
                curr = curr.next;
            } while ( ( curr  != last ) && sorted );
        }

        return sorted;
    } // end isSorted

    /***********************************
     *
     * printList: print out all the items
     *  in a list (for debugging purposes)
     *
     **************************************/

    public void printList()
    {
        Node curr;

        if (nodeCount > 0)
        {
            curr = last.next;
            do
            {
                System.out.println( curr.item );
                curr = curr.next;
            } while ( curr != last.next );
        }
    } // end printList
    
    private boolean isEmpty() {
    	return nodeCount == 0;
    }

} // end e1073 class LinkedList