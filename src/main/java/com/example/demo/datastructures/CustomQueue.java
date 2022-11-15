package com.example.demo.datastructures;

public class CustomQueue<T> {

	private Node<T> head;
	private Node<T> tail;

	public void add( T value ) {
		Node<T> newNode = new Node<>( value, null );
		if(head == null) {
			head = newNode;
		}
		if ( tail != null ) {
			tail.setNext( newNode );
		}
		tail = newNode;
	}

	public T remove() {
		if ( head == null ) {
			return null;
		}
		T value = head.getValue();
		head = head.getNext();
		if(head == null) {
			tail = null;
		}
		return value;
	}

	public T peek() {
		return head.getValue();
	}

	public boolean isEmpty() {
		return head == null;
	}

	private static class Node<T> {
		private T value;
		private Node<T> next;

		public Node( final T value, final Node<T> next ) {
			this.value = value;
			this.next = next;
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
