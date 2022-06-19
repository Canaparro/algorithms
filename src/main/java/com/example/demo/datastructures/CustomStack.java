package com.example.demo.datastructures;

public class CustomStack<T> {

	Element<T> topElement;

	public void add( T value ) {
		Element<T> newElement = new Element<>( value );
		if ( topElement != null ) {
			topElement.setNext( newElement );
			newElement.setPrevious( topElement );
		}
		topElement = newElement;
	}

	public T pop() {
		T value = topElement.getValue();
		topElement = topElement.getPrevious();
		return value;
	}

	class Element<R> {
		private R value;
		private Element<R> next;
		private Element<R> previous;

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

		public Element<R> getPrevious() {
			return previous;
		}

		public void setPrevious( final Element<R> previous ) {
			this.previous = previous;
		}
	}
}
