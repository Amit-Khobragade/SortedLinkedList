package com.struct;

public class SortedLinkedList extends ItemList  {

	///////////////////////////////////////////////////////
	/////////////////// constructor ///////////////////////
	///////////////////////////////////////////////////////
	public SortedLinkedList(){
		super.start = new Node();
		super.end = new Node();
		super.current = super.start;
		super.start.setNext(super.end);
		super.end.setPrevious(super.start);
		this.size = 0;
	}
	
	///////////////////////////////////////////////////////
	///////////////////// Overridden ///////////////////////
	///////////////////////////////////////////////////////
	@Override
	public void add( Item it) {
		Node temp1;
		for( temp1 = super.start; temp1.getNext() != super.end && this.size != 0; temp1 = temp1.getNext() ) {
			if( temp1.getNext().getItem().compareTo(it) <= 0 )
				break;
		}
		this.addAtNode( it, temp1 );
	}
	
	@Override
	public Item remove() {
		if( size == 0 ) {
			System.out.println( "UnderFlow" );
			return null;
		}
		Node temp1 = super.current;
		if( temp1 == super.start )
			temp1 = super.start.getNext();
		else if( temp1 == super.end ) 
			temp1 = super.end.getPrevious();

		if( super.current != super.start || super.current != super.end )
			next();
		
		Item item = temp1.getItem();
		this.removeAtNode(temp1);
		return item;
	}
	@Override
	public Item get( int pos ) {
		pos--;
		Node temp = findNode(pos);
		return temp.getItem();
	}
	
	public Item get() {
		if( super.current == super.start || super.current == super.end ) {
			return null;
		}
		return super.current.getItem();
	}
	

	///////////////////////////////////////////////////////
	///////////////////// printers ////////////////////////
	///////////////////////////////////////////////////////
	public void printAll() {
		int j = 1;
		for( Node i = super.start.getNext(); i != super.end; i = i.getNext() ) {
			System.out.println( j++ + "  ::" );
			i.getItem().print();
		}
			
	}
	
	public void printCurrent() {
		if( super.current == super.start || super.current == super.end ) {
			System.out.println( "At start or end ");
			return;
		}
		super.current.getItem().print();
	}
	

	///////////////////////////////////////////////////////
	//////////////// current modifiers ////////////////////
	///////////////////////////////////////////////////////
	public void next() {
		if( super.current == super.end ) {
			System.out.println( "At end ");
			return;
		}
		super.current = super.current.getNext();
	}
	
	public void previous() {
		if( super.current == super.start ) {
			System.out.println( "At start");
			return;
		}
		super.current = super.current.getPrevious();
	}
	
	public void gotoStart() {
		super.current = super.start;
	}
	
	public void gotoend() {
		super.current = super.end;
	}
	///////////////////////////////////////////////////////
	//////////////// method to find pos ///////////////////
	///////////////////////////////////////////////////////
	private Node findNode( int pos ) {
		if( pos < 0 || pos > this.size ) {
			System.out.println( "Error:: Invalid pos...");
			return null;
		}
		Node temp ;
		if( pos == 0 )
			temp = super.start.getNext();
		else if( pos == this.size )
			temp = super.end.getPrevious(); 
		else if( pos <= size/2 ) { 
			 temp = super.start;
			for( int i = 0; i != pos; ++i ) {
				temp = temp.getNext();
			}
		}
		else {
			 temp = super.end;
				for( int i = this.size; i != pos; --i ) {
					temp = temp.getPrevious();
				}
		}
		return temp;
	}
	
	///////////////////////////////////////////////////////
	////////////// methods to add new items ///////////////
	///////////////////////////////////////////////////////
	private void addAtNode( Item it, Node node ) {
		if( node == super.end )
			node = node.getPrevious();
		Node temp = new Node( node, node.getNext(), it );
		node.getNext().setPrevious(temp);
		node.setNext(temp);
		++size;
	}
	
	

	///////////////////////////////////////////////////////
	////////////// methods to remove items ////////////////
	///////////////////////////////////////////////////////
	private void removeAtNode( Node node) {
		node.getPrevious().setNext(node.getNext());
		node.getNext().setPrevious(node.getPrevious());
		--size;
	}

	///////////////////////////////////////////////////////
	//////////// redundant functions could be /////////////  
	//////////// used in other implementations ////////////
	///////////////////////////////////////////////////////
	private void addToPos( Item it, int pos ) {
		Node temp = this.findNode(pos);
		if( temp == null )
			return;
		addAtNode( it, temp );
	}
	
	
	private Item removeFromPos( int pos ) {
		Node temp = this.findNode(pos);
		if( temp == null )
			return null;
		removeAtNode( temp );
		return temp.getItem();
	}
	
	///////////////////////////////////////////////////////
	/////////////////////// fields ////////////////////////
	///////////////////////////////////////////////////////
	private int size; 
}
