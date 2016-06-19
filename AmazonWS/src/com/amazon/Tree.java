package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	
	public TreeNode root;
	public int count;
	
	public boolean insert(int value)
	{
		if(root==null){
			root=new TreeNode(value);
			count++;
			return Boolean.TRUE;
		}
		insertNode(root,value);
		count++;
		return Boolean.TRUE;
	}

	private void insertNode(TreeNode currentNode,int value) {
		if(value<currentNode.value){
			if(currentNode.leftNode==null)
			{
				currentNode.leftNode=new TreeNode(value);
			}else{
				insertNode(currentNode.leftNode, value);
			}
		}else{
			if(currentNode.rightNode==null)
			{
				currentNode.rightNode=new TreeNode(value);
			}else{
				insertNode(currentNode.rightNode, value);
			}
		}
	}
	
	public boolean contains(TreeNode currentNode,int searchValue)
	{
		if(currentNode==null){
			return Boolean.FALSE;
		}
		
		if(currentNode.value==searchValue){
			return Boolean.TRUE;
		}else if(searchValue<currentNode.value)
		{
			return contains(currentNode.leftNode,searchValue);
			
		}else{
			return contains(currentNode.rightNode,searchValue);
		}
	}
	
	
	/**
	 * the value to remove is a leaf node or
	 * the value to remove has a right subtree, but no left subtree or
	 * the value to remove has  a lOeft subtree , but no right subtree
	 * the value to remove has both left subtree, and right subtree in which case we promote the largest value in the left subtree
	 * the value to remove is a root node (1 st case)
	 * @param value
	 */
	public boolean remove(int value)
	{
		if(root==null){
			return false;
		}
		TreeNode nodeToRemove=findNode(value, root);
		if(nodeToRemove==null){
			return Boolean.FALSE;
		}
		
		TreeNode parent=findParent(value, root);
		if(count==1){
			root=null;
		}else if(nodeToRemove.leftNode==null && nodeToRemove.rightNode==null) { //leafNode case 1
			if(nodeToRemove.value <parent.value){
				parent.leftNode=null;
			}else if(nodeToRemove.value>parent.value){
				parent.rightNode=null;
			}
		}else if(nodeToRemove.leftNode==null && nodeToRemove.rightNode!=null){ // case -2
			if(nodeToRemove.value<parent.value){
				parent.leftNode=nodeToRemove.rightNode;
			}else if(nodeToRemove.value>parent.value){
				parent.rightNode=nodeToRemove.rightNode;
			}
		}else if(nodeToRemove.leftNode!=null && nodeToRemove.rightNode==null){ //Case -3
			if(nodeToRemove.value<parent.value){
				parent.leftNode=nodeToRemove.leftNode;
			}else if(nodeToRemove.value>parent.value){
				parent.rightNode=nodeToRemove.leftNode;
			}
		}else{ //case --4
			TreeNode largestValueNode=nodeToRemove.leftNode;
			while(largestValueNode.rightNode!=null){
				largestValueNode=largestValueNode.rightNode; //get maximum in the left sub tree.
			}
			TreeNode largestValueparent=findParent(largestValueNode.value, root);
			largestValueparent.leftNode=null;
			nodeToRemove.value=largestValueNode.value;
			
		}
		count--;
		return Boolean.TRUE;
	}
	
	/**
	 * 
	 * @param value
	 * @param currentNode
	 * @return parent Node of the value
	 */
	public TreeNode findParent(int value, TreeNode currentNode)
	{
		if(root==null){
			return null;
		}
		
		if(root.value==value){
			return null; //no parent 
		}
		
		if(value<currentNode.value){
			if(currentNode.leftNode==null){
				return null;
			}else if(currentNode.leftNode.value==value){
				return currentNode;
			}else{
				return findParent(value, currentNode.leftNode);
			}
			
		}else{
			if(currentNode.rightNode==null){
				return null;
			}else if(currentNode.rightNode.value==value){
				return currentNode;
			}else{
				return findParent(value, currentNode.rightNode);
			}
		}
	}

	/**
	 * 
	 * @param value
	 * @param currentNode
	 * @return the node of the current value
	 */
	public TreeNode findNode(int value, TreeNode currentNode){
		
		if(root==null){
			return null;
		}
		
		if(root.value==value){
			return root;
		}else if(currentNode.value==value){
			return currentNode;
		}else if(value<currentNode.value){
			return findNode(value, currentNode.leftNode);
		}else {
			return findNode(value, currentNode.rightNode);
		}
		
	}
	
	/**
	 * 
	 * @param currentNode
	 * @return minimum value of the tree.
	 * left most node value
	 */
	public int findMin(TreeNode currentNode)
	{
		if(root==null){
			return Integer.MIN_VALUE;
		}
		if(currentNode.leftNode==null){
			return currentNode.value;
		}else return findMin(root.leftNode);
		
	}
	
	/**
	 * 
	 * @param currentNode
	 * @return Maximum value of BST
	 */
	public int findMax(TreeNode currentNode){
		if(root==null){
			return Integer.MAX_VALUE;
		}
		if(currentNode.rightNode==null){
			return currentNode.value;
		}else{
			return findMax(currentNode.rightNode);
		}
	}
	
	
	public void preorder(TreeNode currentNode){
		if(currentNode!=null){
			printValue(currentNode.value);
			preorder(currentNode.leftNode);
			preorder(currentNode.rightNode);
		}
	}
	
	public void postOrder(TreeNode currentNode){
		if(currentNode!=null){
			postOrder(currentNode.leftNode);
			postOrder(currentNode.rightNode);
			printValue(currentNode.value);
		}
	}
	
	public void printValue(final int value){
		TreeNode parent=findParent(value, root);
		if(parent!=null){
			if(value<parent.value){
				System.out.println("L------>"+value);
			}else{
				System.out.println(value+"<-------R");
			}
		}else{
			System.out.println("----->ROOT---->"+value);
		}
	}
	
	
	public int getDepthOfTree(TreeNode currentNode)
	{
	
		if(root==null){
			return Integer.MIN_VALUE;
		}
		if(root.leftNode==null && root.rightNode==null){
			return 0;
		}
		else{
			
		}
		
		
		return 0;
	}
	
	public void breadthFirst(TreeNode currentNode){
		if(root!=null){
			Queue<TreeNode> queue=new LinkedList<TreeNode>();
			
			while(currentNode!=null){
			
				printValue(currentNode.value);
				
				if(currentNode.leftNode!=null){
					queue.add(currentNode.leftNode);
				}
				if(currentNode.rightNode!=null){
					queue.add(currentNode.rightNode);
				}
				if(queue!=null && !queue.isEmpty()){
					currentNode=queue.poll();
				}else{
					currentNode=null;
				}
			}
		}
	}
	
	public int height(TreeNode currentNode){
		if(root==null|| currentNode==null)
		{
			return 0;
		}
		if(root.leftNode==null && root.rightNode==null)
		{
			return 1;
		}
		int lheight=height(currentNode.leftNode);
		int rheight=height(currentNode.rightNode);
		
		return lheight>rheight?lheight+1:rheight+1;
	}
	@Override
	public String toString() {
		return "Tree [root=" + root + "]";
	}
	
}
