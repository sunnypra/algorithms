package tree;

import tree.BinarySearchTree.BSTNode;

public class Maxnode {
	public static void main(String[] args)
	{
		BinarySearchTree bt =  new BinarySearchTree();
		bt.insetBT(4);bt.insetBT(2);bt.insetBT(8);bt.insetBT(5);
		bt.insetBT(11);bt.insetBT(7);bt.insetBT(6);//bt.insetBT(5);
	
		int res_max=max(bt.root);
		System.out.println(res_max);
	}

	private static int max(BSTNode root) {
		// TODO Auto-generated method stub
	int rt_val,left ,right,max=0;
	if(root==null)
		return -1;
	if(root!=null)
	{
		rt_val=(Integer)root.info;
		left=max(root.left);
		right = max(root.right);
		if(left>right)
		{
			max=left;
		}
		else
			max=right;
		if(rt_val>max)
			max=rt_val;
	}
		
	return max;
	
	}
}
