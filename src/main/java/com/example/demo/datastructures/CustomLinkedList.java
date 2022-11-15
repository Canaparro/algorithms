package com.example.demo.datastructures;

public class CustomLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;

	private int size;

	public CustomLinkedList( T... values ) {

		for ( final T value : values ) {
			if(head == null) {
				head = new Node<>( value );
				tail = head;
			} else {
				tail.setNext( new Node<>( value ) );
				tail = tail.getNext();
			}
			size++;
		}

	}

	public int getSize() {
		return size;
	}

	public void add(T value) {
		Node<T> node = new Node<>( value );
		if(head == null) {
			head = node;
			tail = head;
		} else {
			tail.setNext( node );
			tail = node;
		}
		size++;
	}

	public Node<T> getFirst() {
		return head;
	}

	public void setHead( final Node<T> head ) {
		this.head = head;
	}

	public Object[] toArray() {
		Object[] array = new Object[size];
		int index = 0;
		Node<T> current = head;
		while(current != null) {
			array[index] = current.value;
			current = current.next;
			index++;
		}
		return array;
	}

	public void removeNext( final Node<T> previousNode ) {
		previousNode.setNext( previousNode.getNext().getNext() );
		size --;
	}

	public static class Node<T> {

		private T value;
		private Node<T> next;

		public Node( final T value ) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue( final T value ) {
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext( final Node<T> next ) {
			this.next = next;
		}
	}

}
