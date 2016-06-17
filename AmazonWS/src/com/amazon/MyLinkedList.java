package com.amazon;

public class MyLinkedList 
{
	
	public int value;
	public MyLinkedList linkedList;
	
	public MyLinkedList(final int value) 
	{
		this.value=value;
		this.linkedList=null;
	}

	@Override
	public String toString() {
		return "MyLinkedList [value=" + value + ", linkedList=" + linkedList
				+ "]";
	}
	
	
	
}
