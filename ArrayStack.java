/*
 * this class creates a stack using a dynamic array
 */
public class ArrayStack implements StackInterface {
	
	// creates an instance of a dynamic array
	DynamicArray stack = new DynamicArray();
	
	/*
	 * This method adds a given value to the
	 * top of the stack
	 */
	public void push(int value) {
		stack.append(value);
	}
	
	/*
	 * This method removes and returns the top of the
	 * stack
	 */
	public int pop() {
		int retVal = 0;
		if (stack.get(0) != 0 && stack.size() > 0) {
			retVal = stack.get(stack.size()-1);
			stack.remove(stack.size());
			return retVal;
		}
		else {
			return -1;
		}
	}
	
	/*
	 * This method returns the top of the stack
	 */
	public int peek() {
		if (stack.size() > 0) {
			return stack.get(stack.size()-1);
		}
		return -1;
	}
	
	/*
	 * this method returns a boolean of 
	 * if the list is empty or not
	 */
	public boolean isEmpty() {
		if (stack.size() < 1) {
			return true;
		}
		return false;
	}
	
	/*
	 * This method returns an int representing the size
	 * of the list.
	 */
	public int size() {
		return stack.size();
	}
	
	/*
	 * this method clears the stack
	 */
	public void clear() {
		stack.clear();
	}
	
	/*
	 * This method creates a string representation
	 * of the stack
	 */
	public String toString() {
		String retString = "{";
		for (int i = 0; i < stack.size(); i++) {
			retString += stack.get(i);
			if (i != stack.size()-1) {
				retString += ",";
			}
		}
		retString += "}";
		return retString;
	}
	
	/*
	 * this method returns a boolean of if the 
	 * arraystack is equal to the given object.
	 */
	public boolean equals(Object checkVal) {
		if (checkVal == null){
			return false;
		}
		if (checkVal.getClass() != this.getClass()) {
			return false;
		}
		
		ArrayStack check = (ArrayStack) checkVal;
		
		if (check.size() != stack.size()) {
			return false;
		}
		ArrayStack toCheck = check.copy();
		for (int i = stack.size()-1; i > 0; i--) {
			int temp = toCheck.pop();
			if (stack.get(i) != temp) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * this method creates and returns a copy of the stack
	 */
	public ArrayStack copy() {
		ArrayStack retStack = new ArrayStack();
		for (int i = 0; i < stack.size(); i++) {
			retStack.push(stack.get(i));
		}
		return retStack;
	}
}