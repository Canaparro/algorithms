package com.example.demo.general.book.stacksqueues;

import com.example.demo.datastructures.CustomStack;

public class StackOfPlates<T> {

	private final int capacity;
	private CustomStack<T>[] stacks;
	private int currentStackSize;
	private int currentStack;

	public StackOfPlates( final int capacity ) {
		if(capacity <= 0) throw new IllegalArgumentException("capacity must be higher than zero");
		this.capacity = capacity;
		this.currentStack = 0;
		this.currentStackSize = 0;
		this.stacks = new CustomStack[1];
		this.stacks[currentStack] = new CustomStack<>();
	}

	public void push(T value) {
		if(currentStackSize == capacity) {
			addStack();
		}
		CustomStack<T> stack = stacks[currentStack];
		stack.push( value );
		currentStackSize++;
	}

	public T pop() {
		CustomStack<T> stack = stacks[currentStack];
		T value = stack.pop();
		currentStackSize--;
		if( stack.isEmpty() && currentStack > 0 ) {
			removeStack();
		}
		return value;
	}

	private void addStack() {
		CustomStack<T>[] newStacks = new CustomStack[stacks.length + 1];
		System.arraycopy( stacks, 0, newStacks, 0, stacks.length );
		newStacks[newStacks.length - 1] = new CustomStack<>();
		stacks = newStacks;

		currentStack++;
		currentStackSize = 0;
	}

	private void removeStack() {
		CustomStack<T>[] newStacks = new CustomStack[stacks.length - 1];
		System.arraycopy( stacks, 0, newStacks, 0, stacks.length - 1 );
		stacks = newStacks;

		currentStack--;
		currentStackSize = capacity;
	}

}
