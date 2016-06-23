package com.amazon;

public class TestBST {

	public static void main(String[] args) {

		Tree tree= populateTree(20);
		
//		Tree tree=new Tree();
//		tree.insert(200);
//		tree.insert(123);
//		tree.insert(124);
//		tree.insert(125);
//		tree.insert(126);
//		tree.insert(127);
//		tree.insert(128);
//		tree.insert(201);
//		tree.insert(202);
//		tree.insert(203);
//		tree.insert(204);
//		tree.insert(205);
//		tree.insert(206);
		
		System.out.println(tree.contains(tree.root, 888));
		
		System.out.println("Count---->"+tree.count);
		
		System.out.println("Width:"+tree.getWidth(tree.root.leftNode.leftNode,3));
		System.out.println("Max Width:"+tree.getMaxWidth(tree.root));
		
//		System.out.println("Remove 58---->"+tree.remove(142));
		
		System.out.println("Count---->"+tree.count);
		
		System.out.println(tree);
		
		
		System.out.println("shortest path------>"+tree.shortestPath(tree.root,	 149));
		
		
//		System.out.println("---------------------PREORDER---------------------------");
//		
//		tree.preorder(tree.root);
//		
//		System.out.println("---------------------POSTORDER---------------------------");
//		
//		tree.postOrder(tree.root);
//		
		System.out.println("---------------------BREADTH FIRST SEARCH---------------------------");
//		
		tree.breadthFirstS(tree.root);
//		
		System.out.println("-----------height:"+tree.height(tree.root));
		
		System.out.println("Level----->"+tree.getLevel(tree.root));
		
		
	}
	
	public static Tree populateTree(int range){
		Tree tree=new Tree();
//		for (int i = 1; i <= range; i++) {
//			tree.insert(i*(int)(Math.random()*1000));
//		}
		tree.insert(100);
		tree.insert(88);
		tree.insert(64);
		tree.insert(52);
		tree.insert(42);
		tree.insert(58);
		tree.insert(72);
		tree.insert(92);
		tree.insert(90);
		tree.insert(94);
		tree.insert(128);
		tree.insert(115);
		tree.insert(104);
		tree.insert(120);
		tree.insert(165);
		tree.insert(142);
		tree.insert(132);
		tree.insert(131);
		tree.insert(149);
		tree.insert(151);
		tree.insert(220);
		
		return tree;
	}

}
