/*
 * this class creates a dynamic array
 */
public class DynamicArray {
	private int[] array;
	private int size;
	private static final int DEFAULT = 5;
	
	/*
	 * this method creates the array
	 */
	public DynamicArray() {
		array = new int[DEFAULT];
		size = 0;
	}
	/*
	 * this method returns a boolean if the array is empty
	 */
	public boolean empty() {
		return (array == null);
	}
	
	/*
	 * this method changes the size of the list
	 */
	public void changeSize(int newCapacity) {
		int[] temp = new int[newCapacity];
		size = newCapacity < size ? newCapacity:size;
		for (int i = 0; i < size; i++)
			temp[i] = array[i];
		array = temp;			
	}
	
	/*
	 * this method returns the data at the given index
	 */
	public int get(int index) {
		return array[index];
	}
	
	/*
	 * this method removes the datapoint at a given index
	 * and shifts the list over to the left.
	 */
	public void remove(int index) {
		int[] temp = new int[size];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				i++;
			}
			temp[j] = array[i];
			j++;
		}
		size--;
		array = temp;
	}
	
	/*
	 * this method clears the array and replaces it
	 * with and empty array
	 */
	public void clear() {
		size = 0;
		int[] retArray = new int[DEFAULT];
		array = retArray;
	}
	
	/*
	 * this array retruns the size of 
	 * the array in the form of an int
	 */
	public int size() {
		return size;
	}
	
	/*
	 * this method adds a datapoint to the end
	 * of the list.
	 */
	public void append(int val) {
		if (size >= array.length) {
			changeSize(2*array.length);
		}
		array[size] = val;
		size++;
	}
	
	
}