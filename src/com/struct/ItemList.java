package com.struct;

public abstract class ItemList<T extends Comparisons<T>> {
	///////////////////////////////////////////////////////
	//////////////////// constructor //////////////////////
	///////////////////////////////////////////////////////
	ItemList(){
	}
	
	///////////////////////////////////////////////////////
	////////////////////// abstract ///////////////////////
	///////////////////////////////////////////////////////
	abstract public void add( T it);
	abstract public T remove();
	abstract public T get( int pos );
	
	///////////////////////////////////////////////////////
	////////////////////// methods ////////////////////////
	///////////////////////////////////////////////////////
	public void setItem( T it ) {
		this.current.setItem( it );
	}
	
	public T getItem() {
		return this.current.getItem();
	}
	
	public void printInfo() {
		this.current.getItem().print();
	}
	
	
	
	

	///////////////////////////////////////////////////////
	/////////////////////// fields  ///////////////////////
	///////////////////////////////////////////////////////
	protected Node<T> start = new Node<T>();
	protected Node<T> end = new Node<T>();
	protected Node<T> current = new Node<T>();
}




class Node <T>{
	public Node() {
		this( null, null, null );
	}
	
	public Node( Node<T> previous, Node<T> next, T it ) {
		this.next = next;    
		this.previous = previous;
		this.it = it;
	}
	
	public T getItem() {
		return this.it;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public Node<T> getPrevious() {
		return this.previous;
	}
	

	public void setItem( T it ) {
		this.it = it;
	}
	
	public void setNext( Node<T> next ) {
		this.next = next;
	}

	public void setPrevious( Node<T> previous ) {
		this.previous = previous;
	}

	private T it = null;
	private Node<T> next = null;
	private Node<T> previous = null;
	
}
