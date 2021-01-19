package com.struct;

public abstract class ItemList {
	///////////////////////////////////////////////////////
	//////////////////// constructor //////////////////////
	///////////////////////////////////////////////////////
	ItemList(){
	}
	
	///////////////////////////////////////////////////////
	////////////////////// abstract ///////////////////////
	///////////////////////////////////////////////////////
	abstract public void add( Item it);
	abstract public Item remove();
	abstract public Item get( int pos );
	
	///////////////////////////////////////////////////////
	////////////////////// methods ////////////////////////
	///////////////////////////////////////////////////////
	public void setItem( Item it ) {
		this.current.setItem( it );
	}
	
	public Item getItem() {
		return this.current.getItem();
	}
	
	public void printInfo() {
		this.current.getItem().print();
	}
	
	
	
	

	///////////////////////////////////////////////////////
	/////////////////////// fields  ///////////////////////
	///////////////////////////////////////////////////////
	protected Node start = new Node();
	protected Node end = new Node();
	protected Node current = new Node();
}




class Node{
	public Node() {
		this( null, null, null );
	}
	
	public Node( Node previous, Node next, Item it ) {
		this.next = next;    
		this.previous = previous;
		this.it = it;
	}
	
	public Item getItem() {
		return this.it;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getPrevious() {
		return this.previous;
	}
	

	public void setItem( Item it ) {
		this.it = it;
	}
	
	public void setNext( Node next ) {
		this.next = next;
	}

	public void setPrevious( Node previous ) {
		this.previous = previous;
	}

	private Item it = null;
	private Node next = null;
	private Node previous = null;
	
}
