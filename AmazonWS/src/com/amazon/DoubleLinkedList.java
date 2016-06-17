package com.amazon;

public class DoubleLinkedList {
	DNode head;
	DNode tail;

	public int count;

	public DoubleLinkedList(int value) {
		head=new DNode(value);
		tail=head;
		count++;
	} 
	public DoubleLinkedList() {
		head=null;
		tail=null;
		count=0;
	}
	public boolean add(int value)
	
	{
		if(head==null)
		{
			head=new DNode(value);
			tail=head;
			count++;
			return Boolean.TRUE;
		}
		DNode n= new DNode(value);
		tail.next=n;
		n.prev=tail;
		tail=n;
		tail.toString();
		
		count++;
		return Boolean.TRUE;
	}
	
	public boolean delete(int value)
	{
		if(head==null){
			return Boolean.FALSE;
		}
		
		if(head.value==value){
			if(head.equals(tail)){
				head=null;
				tail=null;
				count--;
				return Boolean.TRUE;
			}
			
			head=head.next;
			head.prev=null;
			count--;
			return Boolean.TRUE;
		}
		
		DNode n=head.next;
		while(n!=null && n.value!=value){
			n=n.next;
		}
		if(n.equals(tail)){
			tail=tail.prev;
			tail.next=null;
			count--;
			return Boolean.TRUE;
		}
		if(n!=null){
			n.prev.next=n.next;
			n.next.prev=n.prev;
			count--;
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public void traverse(){
		
		if(head==null){
			System.out.println("Nothing exist to traverse");
			return;
		}
		DNode n= head;
		System.out.print(" Forward Traverse");
		while(n!=null){
			System.out.print("------>"+n.value);
			n=n.next;
		}
		System.out.println();
		
	}
	
	public void reverseTraverse(){
		if(head==null)
		{
			System.out.println("Nothing exist to traverse");
			return;
		}
		DNode n=tail;
		System.out.print("Reverse traverse");
		while(n!=null){
			System.out.print("------>"+n.value);
			n=n.prev;
		}
		System.out.println();
	}
	@Override
	public String toString() {
		return "DoubleLinkedList [head=" + head + ", tail=" + tail + ", count="
				+ count + "]";
	}
	
	
	
}
