package com.example.demo.general.book.stacksqueues;

import com.example.demo.datastructures.CustomStack;

public class QueueViaStacks<T> {

	private final CustomStack<T> stack = new CustomStack<>();
	private final CustomStack<T> auxiliaryStack = new CustomStack<>();

	public void push(T value) {
		while ( !auxiliaryStack.isEmpty() ) {
			stack.push( auxiliaryStack.pop() );
		}
		stack.push( value );
	}

	public T pop() {
		while ( !stack.isEmpty() ) {
			auxiliaryStack.push( stack.pop() );
		}
		T value = auxiliaryStack.pop();
		return value;
	}
}
