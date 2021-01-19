package com.struct;

public class Item {
	///////////////////////////////////////////////////////
	////////////// saves the object from gc ///////////////
	///////////////////////////////////////////////////////
	public static Item a;
	@Override
	public void finalize() {
		a = this;
	}
	
	///////////////////////////////////////////////////////
	///////////////////// constructor  ////////////////////
	///////////////////////////////////////////////////////
	public Item( int sNo, String name, int amount ){
		this.name = name;
		this.amount = amount;
		this.sNo = sNo;
	}
	

	///////////////////////////////////////////////////////
	/////////////////////// methods ///////////////////////
	///////////////////////////////////////////////////////
	public int compareTo( Item i ) {
		if( this.sNo == i.sNo )
			return 0;
		else if( this.sNo < i.sNo )
			return 1;
		else 
			return -1;
	}
	
	public int addAmount( int toAdd ) {
		if( toAdd < 0 )
			return -1;
		
		this.amount += toAdd;
		return this.amount;
	}
	
	public int decreaseAmount( int toDec ) {
		if( toDec < 0 )
			return -1;
		
		this.amount -= toDec;
		return this.amount;
	}
	
	public void print() {
		System.out.println( "................." );
		System.out.println( "S.No.::\t" + this.sNo );
		System.out.println( "Name::\t" + this.name );
		System.out.println( "Amount::\t" + this.amount );
	}
	///////////////////////////////////////////////////////
	/////////////////////// fields  ///////////////////////
	///////////////////////////////////////////////////////
	private int sNo;
	private String name;
	private int amount;
	
}