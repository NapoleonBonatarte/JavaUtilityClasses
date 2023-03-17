/*
 * this class uses a linked list to create and implement a queue
 */
public class ListQueue implements QueueInterface{
	// creates a new linked list to implement the listqueue
	LinkedList List = new LinkedList();
	
	/*
	 * This function adds a data point to the end of the linked list
	 */
	public void enqueue(int val) {
		List.addLast(val);
	}
	
	/*
	 * This function removes the last value in the queue and 
	 * returns said value
	 */
	public int dequeue() {
		int retVal = List.get(0);
		List.removeFirst();
		return retVal;
	}
	
	/*
	 * This function returns the size of the list in the form 
	 * of an int
	 */
	public int size() {
		return List.size();
	}
	
	/*
	 * This function returns a boolean true if the list is empty,
	 * false if not empty
	 */
	public boolean isEmpty() {
		if (List.size() < 1)
			return true;
		return false;
	}
	
	/*
	 * This method returns the head of the queue
	 */
	public int peek() {
		return List.headData();
	}
	
	/*
	 * This method clears the list and makes it empty
	 */
	public void clear() {
		List.clear();
	}
	
	/*
	 * This method returns the data at the location of the
	 * given index
	 */
	public int get(int index) {
		return List.get(index);
	}
	
	/*
	 * This method creates and returns a string
	 * representation of the list
	 */
	public String toString() {
		String retString = "{";
		for (int i = 0; i < List.size(); i++) {
			retString += List.get(i);
			if (i != List.size()-1) {
				retString += ",";
			}
		}
		retString += "}";
		return retString;
	}
	
	/*
	 * This method overrides the equals function
	 * and returns a boolean of true if the two objects
	 * are equal, false if not.
	 */
	public boolean equals(Object checkVal) {
		if (checkVal == null){
			return false;
		}
		if (checkVal.getClass() != this.getClass()) {
			return false;
		}
		
		ListQueue check = (ListQueue) checkVal;
		
		if (check.size() != List.size()) {
			return false;
		}
		ListQueue toCheck = check.copy();
		for (int i = 0; i < List.size(); i++) {
			int temp = toCheck.dequeue();
			if (List.get(i) != temp) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * This method copies the list and returns
	 * that copy
	 */
	public ListQueue copy() {
		ListQueue retQueue = new ListQueue();
		for (int i = 0; i < List.size(); i++) {
			retQueue.enqueue(List.get(i));
		}
		return retQueue;
	}
}