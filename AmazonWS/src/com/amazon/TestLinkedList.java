package com.amazon;

public class TestLinkedList {
	
	public static void main(String[] args) {
		SinglyLinkedList ll=populateLinkedList(20);
		
		System.out.println(ll);
		
//		System.out.println(ll.contains(1));
//		System.out.println(ll.contains(45));
//		System.out.println(ll.contains(60));
//		System.out.println(ll.contains(12));
//		System.out.println(ll.contains(11));
//		System.out.println(ll.contains(10));
//		System.out.println(ll.contains(15));
//		
//		
//		
//		
//		System.out.println(ll.delete(45));
//		System.out.println(ll);
//		
//		
//		System.out.println(ll.delete(455));
//		System.out.println(ll);
		ll.traverse();
		ll.reverseTraverse();
	}
	
	
	public static SinglyLinkedList populateLinkedList(int range)
	{
		SinglyLinkedList ll=new SinglyLinkedList();
		for (int i = 1; i < range; i++) {
			ll.add(i*(int)(Math.random()*100));
		}
		return ll;
	}

}
