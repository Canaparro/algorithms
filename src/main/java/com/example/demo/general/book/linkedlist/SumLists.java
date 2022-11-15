package com.example.demo.general.book.linkedlist;

import com.example.demo.datastructures.CustomLinkedList;

public class SumLists {

	public static int backwardOrderSum( CustomLinkedList<Integer> firstList,
			CustomLinkedList<Integer> secondList ) {
		return extractBackwardValue( firstList ) + extractBackwardValue( secondList );
	}

	private static int extractBackwardValue( final CustomLinkedList<Integer> list ) {
		CustomLinkedList.Node<Integer> current = list.getFirst();
		int power = 0;
		int total = 0;

		while(current != null) {
			Integer value = current.getValue();
			total += Math.pow(10, power ) * value;
			power++;
			current = current.getNext();
		}
		return total;
	}

	public static int forwardOrderSum(CustomLinkedList<Integer> firstList,
			CustomLinkedList<Integer> secondList ) {
		return extractForwardValue( firstList ) + extractForwardValue( secondList );
	}

	private static int extractForwardValue( final CustomLinkedList<Integer> list ) {
		return extractForwardRecursive(list.getFirst());
	}

	private static int extractForwardRecursive(final CustomLinkedList.Node<Integer> node) {
		if(node.getNext() == null) {
			return node.getValue();
		}

		int previousValue = extractForwardRecursive( node.getNext() );

		int power = (int)Math.log10( previousValue );

		int currentNodeValue = ((int)Math.pow( 10, power + 1 )) * node.getValue();
		return currentNodeValue + previousValue;
	}

	public static CustomLinkedList<Integer> sumBackwardsLists(CustomLinkedList<Integer> firstList,
			CustomLinkedList<Integer> secondList ) {
		CustomLinkedList<Integer> resultList = new CustomLinkedList<>(  );

		addNext(firstList.getFirst(), secondList.getFirst(), 0, resultList );

		return resultList;
	}

	private static void addNext( final CustomLinkedList.Node<Integer> firstNode, final CustomLinkedList.Node<Integer> secondNode, final int toSumUp,
			final CustomLinkedList<Integer> resultList ) {
		if(firstNode == null && secondNode == null) {
			return;
		} else if(firstNode == null) {
			//complete result with second list
			append(resultList, secondNode);
			return;
		} else if(secondNode == null) {
			//complete result with first list
			append(resultList, firstNode);
			return;
		}

		int sum = firstNode.getValue() + secondNode.getValue() + toSumUp;
		int value = sum % 10;
		resultList.add( value );

		addNext(firstNode.getNext(), secondNode.getNext(), sum / 10, resultList );
	}

	private static void append( final CustomLinkedList<Integer> resultList,
			final CustomLinkedList.Node<Integer> node ) {
		CustomLinkedList.Node<Integer> current = node;
		while (current != null) {
			resultList.add( current.getValue() );
			current = current.getNext();
		}
	}

	private static int addListsBackwards(CustomLinkedList.Node<Integer> firstListNode, CustomLinkedList.Node<Integer>secondListNode, CustomLinkedList<Integer> resultList) {
		if(firstListNode.getNext() == null && secondListNode.getNext() == null) {
			return 0;
		}

		if(firstListNode.getNext() == null) {
			firstListNode = firstListNode.getNext();
		}

		if (secondListNode.getNext() == null) {
			secondListNode = secondListNode.getNext();
		}
		int toSumUp = addListsBackwards(firstListNode, secondListNode, resultList);

		int sum = firstListNode.getValue() + secondListNode.getValue() + toSumUp;

		int value = sum % 10;

		addAsHead(value, resultList);

		return sum / 10;
	}

	private static void addAsHead( final int value, final CustomLinkedList<Integer> resultList ) {
		CustomLinkedList.Node<Integer> newHead = new CustomLinkedList.Node<>( value );
		CustomLinkedList.Node<Integer> oldHead = resultList.getFirst();
		newHead.setNext( oldHead );
		resultList.setHead( newHead );
	}
}
