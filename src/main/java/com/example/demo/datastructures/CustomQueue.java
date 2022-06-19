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

	public T pop() {
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

	static class Node<R> {
		private R value;
		private Node<R> next;

		public Node( final R value, final Node<R> next ) {
			this.value = value;
			this.next = next;
		}

		public R getValue() {
			return value;
		}

		public void setValue( final R value ) {
			this.value = value;
		}

		public Node<R> getNext() {
			return next;
		}

		public void setNext( final Node<R> next ) {
			this.next = next;
		}
	}
}
