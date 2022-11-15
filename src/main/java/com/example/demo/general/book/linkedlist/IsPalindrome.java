package com.example.demo.general.book.linkedlist;

import java.util.ArrayDeque;
import java.util.Objects;

import com.example.demo.datastructures.CustomLinkedList;

public class IsPalindrome {

	public static <T> boolean isPalindrome( CustomLinkedList<T> list ) {
		ArrayDeque<T> stack = new ArrayDeque<>();

		CustomLinkedList.Node<T> current = list.getFirst();

		while (current != null) {
			stack.push( current.getValue() );
			current = current.getNext();
		}

		boolean isPalindrome = true;
		CustomLinkedList.Node<T> listCurrent = list.getFirst();

		while( !stack.isEmpty()) {
			T stackCurrent = stack.pop();
			if ( !Objects.equals(listCurrent.getValue(), stackCurrent) ) {
				isPalindrome = false;
				break;
			}
			listCurrent = listCurrent.getNext();
		}

		return isPalindrome;
	}

}
