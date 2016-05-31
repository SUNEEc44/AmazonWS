import java.io.*;
import java.util.*;
import java.util.Scanner;

 class TreeNode {
  public char val;
  public TreeNode left;
  public TreeNode right;
  
  public TreeNode(char x) {
  	val = x;
  	left = null;
  	right = null;
  	}
}
 
public class computeTest {
  private static char node;
  private static TreeNode root;
  
  private static void inorder(TreeNode root)
  {
  	if(root == null)
  	return;
  	
  	inorder(root.left);
  	System.out.print(root.val);
  	inorder(root.right);
  }
  
  private static void readInput() throws IOException{
    Scanner in = new Scanner(System.in);
	node = in.next().charAt(0);
	
	root = new TreeNode('A');
	root.left= new TreeNode('B');
	root.right = new TreeNode('C');
	root.right.left = new TreeNode('D');
	root.right.right = new TreeNode('E');
	root.right.left.left= new TreeNode('F');
	root.right.right.right= new TreeNode('G');
	
  }

private static char printLeftMost(char node){  
  /* Write your logic here */
  /* use root as the root of the binary tree */
  //return the character output
	
	TreeNode findParent=root;
	TreeNode rightParent=root;
	boolean isFound=Boolean.FALSE;
	while(findParent.left!=null )
	{
		
		if(findParent.left.val==node){
			isFound=Boolean.TRUE;
		}
		if(isFound){
			break;
		}else{
			findParent=findParent.left;
		}
		
		
	}
	
	if(isFound){
		return findParent.right.val;
	}else{
		while(rightParent.right!=null )
		{
			
			if(rightParent.right.val==node){
				isFound=Boolean.TRUE;
			}
			if(isFound){
				break;
			}else{
				rightParent=rightParent.right;
			}
			
			
		}
		if(isFound){
			return rightParent.left.val;
		}
	}
	
	char c=0;
	return c;
  
  
}

  public static void main(String args[]) throws IOException{
//    readInput();
//	  node=new TreeNode('E');
	  
	  root = new TreeNode('A');
		root.left= new TreeNode('B');
		root.right = new TreeNode('C');
		root.right.left = new TreeNode('D');
		root.right.right = new TreeNode('E');
		root.right.left.left= new TreeNode('F');
		root.right.right.right= new TreeNode('G');
    System.out.print(printLeftMost('E'));
  }
}