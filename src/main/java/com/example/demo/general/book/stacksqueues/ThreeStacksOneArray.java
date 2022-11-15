package com.example.demo.general.book.stacksqueues;

public class ThreeStacksOneArray {

	private int[] array;
	private int[] cursors;

	private final int stacks = 3;
	private int stacksCapacity;

	public ThreeStacksOneArray( final int stackCapacity ) {
		this.array = new int[stackCapacity * stacks];
		this.cursors = new int[stacks];
		this.stacksCapacity = stackCapacity;
	}

	public void push(int stackNumber, int value) {
		int cursor = cursors[stackNumber - 1];
		if(cursor == stacksCapacity) {
			throw new IllegalStateException("stack " + stackNumber + " is full");
		} else {
			array[cursor + 1] = value;
			cursors[stackNumber - 1]++;
		}
	}

	public int pop(int stackNumber, int value) {
		int cursor = cursors[stackNumber - 1];
		int result = array[cursor];
		cursors[stackNumber - 1]--;
		return result;
	}
}
