/*
 * this class creates a linked list
 * NOTE: Only accepts Integers
 */
public class LinkedList{
	
	/*
	 * this creates an instance of a private class
	 * that is used in the rest of the linked
	 * list
	 */
	private class Node{
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
		
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	/*
	 * this method adds a given value to the end of the linked
	 * list
	 */
	public void addLast (int data) {
		Node newNode = new Node(data);
		size++;
		
		if (head == null) {
			head = newNode;
			tail = newNode;		
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	/*
	 * this method clears the linked list
	 */
	public void clear() {
		size = 0;
		Node newNode = new Node(0);
		head = newNode;
		tail = newNode;
	}
	
	/*
	 * this method gets the last datapoint in the list
	 */
	public int getLast() {
		return tail.data;
	}
	
	/*
	 * this method retruns the value at the given index
	 */
	public int get(int index) {
		Node cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.data;
	}
	
	/*
	 * this method removes the last node in the 
	 * linked list
	 */
	public void removeLast() {
		Node cur = head;
		if (cur != null) {
			while (cur != null) {
				if (cur.next != null) {
				if (cur.next.next == null){
					cur.next = null;
					tail = cur;
				}
				}
				cur = cur.next;
			}
			size = size - 1;
		}
	}
	
	/*
	 * this method returns the data at the head of the list
	 */
	public int headData() {
		return head.data;
	}
	
	/*
	 * this method removes the first element of the
	 * linked list
	 */
	public void removeFirst() {
		head = head.next;
		size--;
	}
	
	/*
	 * this method adds a givnen value to the front of 
	 * the list
	 */
	public void addFirst(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	/*
	 * this method returns the size of the linked list
	 */
	public int size() {
		return size;
	}
	
}
