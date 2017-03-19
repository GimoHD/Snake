package util;

/**
 *
 * @author Kristof T'Jonck
 *
 *         Singly linked list
 *
 * @param <T>
 *            type of the parameter
 */
public class LinkedList<T> {
	private Node<T> head;
	protected int size;

	/**
	 * Constructor of an empty list
	 */
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Constructor for a linked list with one element
	 *
	 * @param element
	 */
	public LinkedList(T element) {
		this.head = new Node<>(element);
		this.size = 1;
	}

	private LinkedList(Node<T> node) {
		this.head = node;
		this.size = this.count(node, 0);
	}

	/**
	 *
	 * Prepend the element to the linkedlist
	 *
	 * @param element
	 */
	public void prepend(T element) {
		Node<T> newNode = new Node<>(element, this.head);
		this.head = newNode;
		this.size++;
	}

	/**
	 *
	 * @return the head of the list
	 */
	public T first() {
		if (this.head == null) {
			return null;
		}
		return this.head.get();
	}

	private Node<T> lastRecursive(Node<T> current) {
		if (current.next() == null) {
			return current;
		} else {
			return this.lastRecursive(current.next());
		}
	}

	/**
	 *
	 * @return the last element of the list
	 */
	public T last() {
		return this.lastRecursive(this.head).get();
	}

	/**
	 *
	 * @return the number of elements in the linked list
	 */
	public int size() {
		return this.size;
	}

	/**
	 *
	 * @return the linked list without the head element
	 */
	public LinkedList<T> tail() {
		return new LinkedList<>(this.head.next());
	}

	/**
	 *
	 * @return true is empty, false is not empty
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Find the element in the list
	 *
	 * @param element
	 *            to find
	 * @return true if element is present in the list otherwise false
	 */
	public boolean find(T element) {
		Debugger.print("METHOD FIND ELEMENT");
		Node<T> cursor = this.head;
		do {
			if (cursor.get().equals(element)) {
				return true;
			}
			cursor = cursor.next();
		} while ((cursor != null) && (cursor.next() != null));
		return false;
	}

	private int count(Node<T> current, int total) {
		if (current == null) {
			return total;
		}
		return this.count(current.next(), ++total);
	}

	public Node<T> getHead() {
		return this.head;
	}
}