package tree;

import tree.BinarySearchTree.BSTNode;

import com.sec.java.queue.ArrayQueue;

public class HeightofTree {
	public static void main(String[] args)
	{
		BinarySearchTree bt =  new BinarySearchTree();
		bt.insetBT(4);bt.insetBT(2);bt.insetBT(8);bt.insetBT(5);
		bt.insetBT(11);bt.insetBT(7);bt.insetBT(6);//bt.insetBT(5);
	int height =sizeoftree(bt.root);
	System.out.println("res"+height);
	}

	private static int sizeoftree(BSTNode root) {
		// TODO Auto-generated method stub
		
		if(root==null)
			return 0;
		else
			return sizeoftree(root.left)+1+sizeoftree(root.left);
		//return 0;
	}
}