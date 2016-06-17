package com.amazon;

public class SinglyLinkedList {
	Node head;
	Node tail;
	
	public SinglyLinkedList() {
		head=null;
		tail=null;
	}
	
	public SinglyLinkedList(int value){
		head=new Node(value);
		tail=head;
	}
	
	public boolean add(int value)
	{
		if(head==null){
			head=new Node(value);
			tail=head;
		}else{
			Node node=new Node(value);
			tail.next=node;
			tail=node;
		}
		return Boolean.TRUE;
		
	}
	
	public boolean contains(int value)
	{
		
		if(head==null)
		{
			return Boolean.FALSE;
		}
		Node n=head;
		
		while(n!=null && n.value!=value){
			n=n.next;
		}
		if(n==null){
			return Boolean.FALSE;
		}
		return  Boolean.TRUE;
	}
	
	public boolean delete(int value){
		if(head==null){
			return Boolean.FALSE;
		}
		
		Node n = head;
		if(n.value==value)
		{
			if(head.equals(tail)){
				head=null;
				tail=null;
			}else{
				head=head.next;
			}
			return Boolean.TRUE;
		}
			while(n.next!=null && n.next.value!=value){
				n=n.next;
			}
			if(n.next!=null)
			{
				if(n.next.equals(tail)){
					tail=n;
				}else{
					n.next=n.next.next;
				}
				return Boolean.TRUE;	
			}
			
		return Boolean.FALSE;
		
	}
	
	public void traverse(){
		if(head==null){
			System.out.println("Noting is there to traverse");
			return;
		}
		
		Node n=head;
		System.out.print("Forward traverse");
		while(n!=null){
			System.out.print("---->"+n.value);
			n=n.next;
		}
		System.out.println();
	}

	public void reverseTraverse(){
		if(head==null){
			System.out.println("Noting is there to traverse");
			return;
		}
		System.out.print("Reverse Traversing");
		Node current=null;
		if(tail!=null)
		{
			current=tail;
			Node prev=null;
			while(!current.equals(head))
			{
				prev=head;
				while(!prev.next.equals(current))
				{
					prev=prev.next;
				}
				System.out.print("---->"+current.value);
				current=prev;
			}
			System.out.print("---->"+current.value);
		}
		
	}
	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + ", tail=" + tail + "]";
	}
	
	

}
