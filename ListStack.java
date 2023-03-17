/*
 * this class creates a stack using a linked list
 */
public class ListStack implements StackInterface{
	
	// This creates an instance of a linked list
	LinkedList list = new LinkedList();
	
	/*
	 * This method puts a data point at the top
	 * of the stack
	 */
	public void push(int val) {
		list.addLast(val);
	}
	
	/*
	 * This method removes the top of a stack and 
	 * returns that value.
	 */
	public int pop() {
		int retVal = 0;
		if (list.size() > 0) {
			list.removeLast();
			return retVal;
		}
		return -1;
	}
	
	/*
	 * This method returns an int that
	 * represents the size of the stack.
	 */
	public int size() {
		return list.size();
	}
	
	/*
	 * This method returns a boolean if the object
	 * is empty or not.
	 */
	public boolean isEmpty() {
		if (list.size() < 1) {
			return true;
		}
		return false;
	}
	
	/*
	 * This method returns the top of the stack
	 */
	public int peek() {
		return list.getLast();
	}
	
	/*
	 * This method clears the stack
	 */
	public void clear() {
		list.clear();
	}
	
	/*
	 * This method returns the data value at the given index
	 */
	public int get(int index) {
		return list.get(index);
	}
	
	/*
	 * This method creates a String representation of the stack
	 */
	public String toString() {
		String retString = "{";
		for (int i = 0; i < list.size(); i++) {
			retString += list.get(i);
			if (i != list.size()-1) {
				retString += ",";
			}
		}
		retString += "}";
		return retString;
	}
	
	/*
	 * This method overrides the equals method and returns
	 * a boolean of if the object is equal.
	 */
	public boolean equals(Object checkVal) {
		if (checkVal == null){
			return false;
		}
		if (checkVal.getClass() != this.getClass()) {
			return false;
		}
		
		ListStack check = (ListStack) checkVal;
		
		if (check.size() != list.size()) {
			return false;
		}
		ListStack toCheck = check.copy();
		for (int i = list.size()-1; i > 0; i--) {
			int temp = toCheck.get(i);
			if (list.get(i) != temp) {
				return false;
			}
		}
		return true;	}
	
	/*
	 * This method creates and returns a copy of the stack
	 */
	public ListStack copy() {
		ListStack retStack = new ListStack();
		for (int i = 0; i < list.size(); i++) {
			retStack.push(list.get(i));
		}
		return retStack;
	}
}