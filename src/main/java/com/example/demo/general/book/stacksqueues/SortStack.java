package com.example.demo.general.book.stacksqueues;

import com.example.demo.datastructures.CustomStack;

public class SortStack {

	public static CustomStack<Integer> order( CustomStack<Integer> stack) {
		CustomStack<Integer> auxStack = new CustomStack<>();

		while( !stack.isEmpty() ) {
			processValue( stack, auxStack);
		}

		return auxStack;
	}

	private static void processValue( final CustomStack<Integer> stack,
			final CustomStack<Integer> auxStack) {
		Integer value = stack.pop();

		if( auxStack.isEmpty() || value < auxStack.peek() ) {
			auxStack.push( value );
		} else {
			while(auxStack.peek() < value) {
				stack.push( auxStack.pop() );
			}
			auxStack.push( value );
		}
	}
}
