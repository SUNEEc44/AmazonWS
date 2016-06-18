package com.amazon;

public class TestBST {

	public static void main(String[] args) {

		Tree tree= populateTree(20);
		
//		Tree tree=new Tree();
		tree.insert(200);
		tree.insert(123);
		tree.insert(124);
		tree.insert(125);
		tree.insert(126);
		tree.insert(127);
		tree.insert(128);
		tree.insert(201);
		tree.insert(202);
		tree.insert(203);
		tree.insert(204);
		tree.insert(205);
		tree.insert(206);
		
		System.out.println(tree.contains(tree.root, 888));
		
		System.out.println("Count---->"+tree.count);
		System.out.println(tree);
		
		System.out.println("---------------------PREORDER---------------------------");
		
		tree.preorder(tree.root);
		
		System.out.println("---------------------POSTORDER---------------------------");
		
		tree.postOrder(tree.root);
	}
	
	public static Tree populateTree(int range){
		Tree tree=new Tree();
		for (int i = 1; i <= range; i++) {
			tree.insert(i*(int)(Math.random()*1000));
		}
		return tree;
	}

}
