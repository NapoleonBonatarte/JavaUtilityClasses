/*
 * this class creates a queue using a dynamic array
 */
public class ArrayQueue implements QueueInterface{
	
	// this creates an instance of dynamic array
	DynamicArray array = new DynamicArray();
	
	/*
	 * This method returns an int representing
	 * the size of the queue
	 */
	public int size() {
		return array.size();
	}
	
	/*
	 * this method adds a new datapoint at the
	 * end of the queue
	 */
	public void enqueue(int val) {
		array.append(val);
	}
	
	/*
	 * this method returns a boolean of if the queue is
	 * empty or not
	 */
	public boolean isEmpty() {
		if (array.size() < 1) {
			return true;
		}
		return false;
	}
	
	/*
	 * this method returns the front of the queue
	 */
	public int peek() {
		return array.get(0);
	}
	
	/*
	 * this method clears the queue
	 */
	public void clear() {
		array.clear();
	}
	
	/*
	 * this method returns and removes the front of the queue
	 */
	public int dequeue() {
		int retVal = 0;
		if (array.size() > 0) {
			retVal = array.get(0);
			array.remove(0);
			return retVal;
		}
		return -1;
	}
	/*
	 * this method returns the data point at
	 * the given index
	 */
	public int get(int index) {
		return array.get(index);
	}
	
	/*
	 * this method returns a string representation
	 * of the queue
	 */
	public String toString() {
		String retString = "{";
		for (int i = 0; i < array.size(); i++) {
			retString += array.get(i);
			if (i != array.size()-1) {
				retString += ",";
			}
		}
		retString += "}";
		return retString;
	}
	
	/*
	 * this method returns a boolean of true if the
	 * given object is queal to the queue and false
	 * if not
	 */
	public boolean equals(Object checkVal) {
		if (checkVal == null){
			return false;
		}
		if (checkVal.getClass() != this.getClass()) {
			return false;
		}
		
		ArrayQueue check = (ArrayQueue) checkVal;
		
		if (check.size() != array.size()) {
			return false;
		}
		ArrayQueue toCheck = check.copy();
		for (int i = 0; i < array.size(); i++) {
			int temp = toCheck.dequeue();
			if (array.get(i) != temp) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * this method creates and returns a copy of the queue
	 */
	public ArrayQueue copy() {
		ArrayQueue retQueue = new ArrayQueue();
		for (int i = 0; i < array.size(); i++) {
			retQueue.enqueue(array.get(i));
		}
		return retQueue;
	}
}