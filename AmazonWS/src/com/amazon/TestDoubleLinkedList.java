package com.amazon;

public class TestDoubleLinkedList {
	
	public static void main(String[] args) {
		DoubleLinkedList ll=populateLinkedList(20);
		
		System.out.println(ll);
		
		System.out.println(ll.count);
		

		ll.traverse();
		ll.reverseTraverse();
	}
	public static DoubleLinkedList populateLinkedList(int range)
	{
		DoubleLinkedList ll=new DoubleLinkedList();
		for (int i = 1; i <=range; i++) {
			ll.add(i*(int)(Math.random()*100));
		}
		return ll;
	}

}
