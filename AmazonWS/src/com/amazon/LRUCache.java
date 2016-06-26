package com.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author svaduka
 *
 *The least Resent Use is a mechanism to create a cache 
 * where cache is going to get the key
 * if capacity reaches its threshold value
 * i need to remove the least recently used from the cache
 * 
 * The implementation
 * is hashtable for search key,value --- value being the node
 * 
 */
public class LRUCache {
	
	int capacity;
	Map<Integer, DNode> map=new HashMap<Integer, DNode>();
	DNode head=null;
	DNode end=null;
	
	
	//pass capacity to create LRUCache
	
	public LRUCache(int capacity){
		this.capacity=capacity;
	}
	
	public boolean set(int key,int value)
	{
		if(map.containsKey(key))
		{
			DNode old=map.get(key);
			old.value=value;
		}
		return Boolean.TRUE;
	}
	

	public void remove(DNode n){
		if(n.prev!=null){
			n.prev.next=n.next;
		}else{
			head=n.next;
		}
		
		if(n.next!=null){
			n.next.prev=n.prev;
		}else{
			end=n.prev;
		}
	}
}
