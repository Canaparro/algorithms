package com.example.demo.general.book.linkedlist;

import java.util.HashSet;

import com.example.demo.datastructures.CustomLinkedList;

public class Intersection {

	public static <T> CustomLinkedList.Node<T> isIntersected( CustomLinkedList<T> list1, CustomLinkedList<T> list2) {
		CustomLinkedList.Node<T> intersection = null;
		HashSet<CustomLinkedList.Node<T>> existingNodes = new HashSet<>();

		CustomLinkedList.Node<T> currentList1 = list1.getFirst();
		while ( currentList1 != null ) {
			existingNodes.add( currentList1 );
			currentList1 = currentList1.getNext();
		}

		CustomLinkedList.Node<T> currentList2 = list2.getFirst();
		while ( currentList2 != null ) {
			if(existingNodes.contains( currentList2 )) {
				intersection = currentList2;
				break;
			}
			currentList2 = currentList2.getNext();
		}

		return intersection;
	}

	public static <T> CustomLinkedList.Node<T> isIntersectedSmart( CustomLinkedList<T> list1, CustomLinkedList<T> list2) {
		IntersectionCheckResult isIntersected = isThereIntersection(list1, list2);

		if(isIntersected.isIntersected) {
			return getIntersection(list1, list2, isIntersected.listSize1, isIntersected.listSize2);
		} else {
			return null;
		}
	}

	private static <T> CustomLinkedList.Node<T> getIntersection( final CustomLinkedList<T> list1,
			final CustomLinkedList<T> list2, final long listSize1, final long listSize2 ) {

		CustomLinkedList.Node<T> list1Current = list1.getFirst();
		CustomLinkedList.Node<T> list2Current = list2.getFirst();

		if(listSize1 > listSize2) {
			for ( int i = 0; i < listSize1 - listSize2; i++ ) {
				list1Current = list1Current.getNext();
			}
		} else if (listSize1 < listSize2) {
			for ( int i = 0; i < listSize2 - listSize1; i++ ) {
				list2Current = list2Current.getNext();
			}
		}

		return getIntersectionNode(list1Current, list2Current);
	}

	private static <T> CustomLinkedList.Node<T> getIntersectionNode( CustomLinkedList.Node<T> list1Current,
			CustomLinkedList.Node<T> list2Current ) {
		CustomLinkedList.Node<T> intersection = null;
		while(list1Current != null && list2Current != null) {
			if(list1Current == list2Current) {
				intersection = list1Current;
				break;
			} else {
				list1Current = list1Current.getNext();
				list2Current = list2Current.getNext();
			}
		}
		return intersection;
	}

	private static <T> IntersectionCheckResult isThereIntersection( final CustomLinkedList<T> list1,
			final CustomLinkedList<T> list2 ) {
		CustomLinkedList.Node<T> currentList1 = list1.getFirst();
		CustomLinkedList.Node<T> currentList2 = list2.getFirst();

		CustomLinkedList.Node<T> lastNode1 = null;
		CustomLinkedList.Node<T> lastNode2 = null;

		long listSize1 = 0;
		long listSize2 = 0;

		while(currentList1 != null && currentList2 != null) {
			lastNode1 = currentList1;
			currentList1 = currentList1.getNext();

			lastNode2 = currentList2;
			currentList2 = currentList2.getNext();
			listSize1 ++;
			listSize2 ++;
		}

		while(currentList1 != null) {
			lastNode1 = currentList1;
			currentList1 = currentList1.getNext();
			listSize1 ++;
		}

		while(currentList2 != null) {
			lastNode2 = currentList2;
			currentList2 = currentList2.getNext();
			listSize2 ++;
		}

		return new IntersectionCheckResult( listSize1, listSize2, lastNode1 == lastNode2 );
	}

	static class IntersectionCheckResult {
		long listSize1;
		long listSize2;
		boolean isIntersected;

		public IntersectionCheckResult( final long listSize1, final long listSize2,
				final boolean isIntersected ) {
			this.listSize1 = listSize1;
			this.listSize2 = listSize2;
			this.isIntersected = isIntersected;
		}
	}
}
