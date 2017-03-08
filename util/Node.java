package util;
public class Node<T>{
		private T element;
		private Node<T> next;
		
		//constructor overloading
		public Node(T element){
			this(element, null);
		}
		
		public Node(T element, Node<T> next){
			this.element = element;
			this.next = next;
		}
		
		public T get(){
			return element;
		}
		
		public Node<T> next(){
			return next;
		}
		
		public void set(T element) {
			this.element = element;
		}
		
		public void setNext(Node<T> node) {
			next = node;
		}
	}