package com.amazon;

public class TreeNode {
	
	public int value;
	public TreeNode rightNode;
	public TreeNode leftNode;
	
	public TreeNode(int value){
		this.value=value;
		rightNode=null;
		leftNode=null;
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + ", rightNode=" + rightNode
				+ ", leftNode=" + leftNode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((leftNode == null) ? 0 : leftNode.hashCode());
		result = prime * result
				+ ((rightNode == null) ? 0 : rightNode.hashCode());
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
		TreeNode other = (TreeNode) obj;
		if (leftNode == null) {
			if (other.leftNode != null)
				return false;
		} else if (!leftNode.equals(other.leftNode))
			return false;
		if (rightNode == null) {
			if (other.rightNode != null)
				return false;
		} else if (!rightNode.equals(other.rightNode))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	
	
}
