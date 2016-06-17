package com.amazon;

public class DNode {
	
	public int value;
	public DNode next;
	public DNode prev;
	
	
	public DNode(int value){
		this.value=value;
		this.next=null;
		this.prev=null;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DNode [value=" + value + ", next=" + next + "]";
	}

	
}
