package tree;

import tree.BinarySearchTree.BSTNode;

import com.sec.java.queue.ArrayQueue;
import com.sec.java.stack.ArrayStack;

public class LevelOrder {
	public static void main(String[] args)
	{
		BinarySearchTree bt =  new BinarySearchTree();
		bt.insetBT(4);bt.insetBT(2);bt.insetBT(8);bt.insetBT(5);
		bt.insetBT(11);bt.insetBT(7);bt.insetBT(6);//bt.insetBT(5);
	
		ArrayQueue  arr = new ArrayQueue();
		arr.enqueue(bt.root);
		while(!arr.isEmpty())
		{
			BSTNode bt1 = (BSTNode) arr.dequeue();
			System.out.println("elemnt:"+bt1.info);
			if(bt1.left!=null)
				arr.enqueue(bt1.left);
			if(bt1.right!=null)
				arr.enqueue(bt1.right);
		}
		
	//Reverse Level order	
		System.out.println("Reverse Level Order");
		int heigthoftree =height(bt.root);
		
		
		for (int i=heigthoftree;i>0;i--)
		{
			printlevel(bt.root,i);
		}
	}
	private static void printlevel(BSTNode root, int i) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		if(i==1)
			System.out.println(root.info);
		else
		{
			printlevel(root.left, i-1);
			printlevel(root.right , i-1);
		}
		
	}
	static int height(BSTNode node)
	{
	    if (node==null)
	        return 0;
	    else
	    {
	        /* compute the height of each subtree */
	        int lheight = height(node.left);
	        int rheight = height(node.right);
	 
	        /* use the larger one */
	        if (lheight > rheight)
	            return(lheight+1);
	        else return(rheight+1);
	    }
	}
}
