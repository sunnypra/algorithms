package tree;

import tree.BinarySearchTree.BSTNode;

public class removeOutsideRange {
	public static void main(String [] args)
	{
		BinarySearchTree bt =  new BinarySearchTree();
		bt.insert(4);bt.insert(2);bt.insert(8);bt.insert(5);
		bt.insert(11);bt.insert(7);bt.insert(6);//bt.insert(5);
		BSTNode res=removeOutside(BinarySearchTree.root,2,7);
		
	System.out.print("res:"+bt.numberOfNodes(res));
	}

	private static BSTNode removeOutside(BSTNode root, int i, int j) {
		// TODO Auto-generated method stub
		if(root == null)
			return null;
		
		root.left =  removeOutside( root.left,  i,  j);
		root.right = removeOutside( root.right,  i,  j);
		if((Integer)root.info < i)
		{
			BSTNode right =root.right;
			return right;
			}
		if((Integer)root.info >j)
		{
			BSTNode left =root.left;
			return left;
			
		}
	return root;
	}

}
