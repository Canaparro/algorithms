package com.example.demo.datastructures;

public class CustomStack<T> {

	Element<T> topElement;

	public void push( T value ) {
		Element<T> newElement = new Element<>( value );
		if ( topElement != null ) {
			newElement.setNext( topElement );
		}
		topElement = newElement;
	}

	public T pop() {
		T value = topElement.getValue();
		topElement = topElement.getNext();
		return value;
	}

	public T peek() {
		return topElement.getValue();
	}

	public boolean isEmpty() {
		return topElement == null;
	}

	class Element<R> {
		private R value;
		private Element<R> next;

		public Element( final R value ) {
			this.value = value;
		}

		public R getValue() {
			return value;
		}

		public void setValue( final R value ) {
			this.value = value;
		}

		public Element<R> getNext() {
			return next;
		}

		public void setNext( final Element<R> next ) {
			this.next = next;
		}
	}
}
