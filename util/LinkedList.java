package util;

/**
 * 
 * @author Kristof T'Jonck
 * 
 * Singly linked list
 *
 * @param <T> type of the parameter
 */
public class LinkedList<T> {
	private Node<T> head;
	private int size;
	
	/**
	 * Constructor of an empty list
	 */
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	/**
	 * Constructor for a linked list with one element
	 * 
	 * @param element
	 */
	public LinkedList(T element){
		head = new Node<T>(element);
		size = 1;
	}
	
	private LinkedList(Node<T> node){
		head = node;
		size = count(node,0);
	}
	
	/**
	 * 
	 * Prepend the element to the linkedlist
	 * 
	 * @param element
	 */
	public void prepend(T element){
		Node<T> newNode = new Node<T>(element, head);
		head = newNode;	
		size++;
	}
	
	/**
	 * 
	 * @return the head of the list
	 */
	public T first(){
		if(head == null) return null;
		return head.get();
	}
	
	
	private Node<T> lastRecursive(Node<T> current){
		if (current.next() == null){
			return current;
		}
		else {
			return lastRecursive(current.next());
		}
	}
	
	/**
	 * 
	 * @return the last element of the list
	 */
	public T last(){
		return lastRecursive(head).get();
	}
	
	/**
	 * 
	 * @return the number of elements in the linked list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * 
	 * @return the linked list without the head element
	 */
	public LinkedList<T> tail(){
		return new LinkedList<T>(head.next());
	}
	
	/**
	 * 
	 * @return true is empty, false is not empty
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * Find the element in the list
	 * @param element to find
	 * @return true if element is present in the list otherwise false
	 */
	public boolean find(T element){
		Debugger.print("METHOD FIND ELEMENT");
		Node<T> cursor = head;
		do{
			if(cursor.get().equals(element)){
				return true;
			}
			cursor = cursor.next();
		}
		while(cursor !=null && cursor.next() != null);
		return false;
	}
	
	private int count(Node<T> current, int total){
		if(current == null){
			return total;
		}return count(current.next(), ++total);
	}

	
	public Node<T> getHead(){
    	return head;
    }
}