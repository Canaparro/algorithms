package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.LinkedList;

public class CustomHashMap<K, V> {

	private LinkedList<Node<K, V>>[] array = new LinkedList[0];

	private int maxMapSize = 10;

	public static void main( String[] args ) {
		CustomHashMap<String, Person> customHashMap = new CustomHashMap<>();

		System.out.println( "Jacob: " + customHashMap.calculateIndex( "Jacob" ) );
		System.out.println( "Natalie: " + customHashMap.calculateIndex( "Natalie" ) );
		System.out.println( "Ron: " + customHashMap.calculateIndex( "Ron" ) );
		System.out.println( "Marren: " + customHashMap.calculateIndex( "Marren" ) );

		Person jacob = new Person( "Jacob", 39 );
		Person natalie = new Person( "Natalie", 32 );
		Person ron = new Person( "Ron", 27 );
		Person marren = new Person( "Marren", 15 );

		customHashMap.put( jacob.name(), jacob );
		customHashMap.put( natalie.name(), natalie );
		customHashMap.put( ron.name(), ron );
		customHashMap.put( marren.name(), marren );

		//Putting twice should replace element
		marren = new Person( "Marren", 14 );
		customHashMap.put( marren.name(), marren );

		System.out.println( Arrays.toString( customHashMap.array ) );

		System.out.println( customHashMap.get( "Jacob" ) );
		System.out.println( customHashMap.get( "Natalie" ) );
		System.out.println( customHashMap.get( "Ron" ) );
		System.out.println( customHashMap.get( "Marren" ) );
	}

	private void put( K key, V value ) {
		int position = calculateIndex( key );
		if ( position > array.length - 1 ) {
			array = Arrays.copyOf( array, position + 1 );
		}

		LinkedList<Node<K, V>> linkedList = array[position];
		if ( linkedList != null ) {
			boolean elementFound = false;
			for ( final Node<K, V> node : linkedList ) {
				if ( node.getKey().equals( key ) ) {
					node.setValue( value );
					elementFound = true;
					break;
				}
			}
			if ( !elementFound ) {
				linkedList.add( new Node<>( key, value ) );
			}
		} else {
			linkedList = new LinkedList<>();
			array[position] = linkedList;
			linkedList.add( new Node<>( key, value ) );
		}
	}

	private V get( K key ) {
		int position = calculateIndex( key );
		LinkedList<Node<K, V>> linkedList = array[position];
		if ( linkedList != null ) {
			for ( final Node<K, V> node : linkedList ) {
				if ( key.equals( node.getKey() ) ) {
					return node.getValue();
				}
			}
		}
		return null;
	}

	public int calculateIndex( final K key ) {
		int hashCode = key.hashCode();
		return mapToIndex( hashCode );
	}

	private int mapToIndex( int hash ) {
		int index = hash % maxMapSize;
		return Math.abs( index );
	}

	class Node<T, R> {
		private T key;
		private R value;

		public Node( final T key, final R value ) {
			this.key = key;
			this.value = value;
		}

		public T getKey() {
			return key;
		}

		public void setKey( final T key ) {
			this.key = key;
		}

		public R getValue() {
			return value;
		}

		public void setValue( final R value ) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node{" + "key=" + key + ", value=" + value + '}';
		}
	}

	record Person(String name, int age) {}
}
