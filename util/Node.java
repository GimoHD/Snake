package util;

public class Node<T> {
	private T element;
	private Node<T> next;

	public Node(T element) {
		this(element, null);
	}

	public Node(T element, Node<T> next) {
		this.element = element;
		this.next = next;
	}

	public T get() {
		return this.element;
	}

	public Node<T> next() {
		return this.next;
	}

	public void set(T element) {
		this.element = element;
	}

	public void setNext(Node<T> node) {
		this.next = node;
	}
}