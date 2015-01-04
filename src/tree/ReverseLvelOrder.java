package tree;

import tree.BinarySearchTree.BSTNode;

//import tree.BinarySearchTree.BSTNode;

public class ReverseLvelOrder {
	//static BSTNode root1=new BSTNode();
	public static void main(String [] args)
	{
		BinarySearchTree bt =  new BinarySearchTree();
		bt.insert(4);bt.insert(2);bt.insert(8);bt.insert(5);
		bt.insert(11);bt.insert(7);bt.insert(6);//bt.insert(5);
		//int height = height(bt.root);
		//System.out.println("height:"+height);
		/*for(int i=height;i>0;i--)
		{
			System.out.println("height at:"+i);
			printGivenLevel(bt.root, i);
		}*/
		//root1=bt.root;
		System.out.print(sumTheTree(bt.root));
		bt.reset(1);
		while(!bt.inOrderQueue.isEmpty())
		{
			System.out.println("element :"+bt.inOrderQueue.dequeue());
		}
		
	}
	public static int sumTheTree(BSTNode root) {		
		if (root == null) {
			return 0;
		}		
		root.info = (Integer)root.info + sumTheTree(root.left) + sumTheTree(root.right);		
		return(Integer) root.info;
	}
	
	/* static int  printGivenLevel(BSTNode root) {
		//if(root==null)
		//	return 0;
		//root.left.info=printGivenLevel(root.left);
		//root.right.info=printGivenLevel(root.right);
		//return (Integer)root.info+(Integer)root.left.info+(Integer)root.right.info;
		// System.out.println (""+(Integer)root.info+printGivenLevel(root.left)+printGivenLevel(root.left));
		  int sum = (Integer)root.info;

		    if (root.left  != null) sum += printGivenLevel( root.left);
		    if (root.right  != null) sum += printGivenLevel( root.right);

		    return root;
		 root.info= (Integer)root.info+printGivenLevel(root.left)+printGivenLevel(root.right);
		 //return 0;
		// TODO Auto-generated method stub
		if(root == null)
			return;
		if(i==1)
			System.out.println("element:"+root.info);
		else if(i>1)
		{
			printGivenLevel(root.left,i-1);
			printGivenLevel(root.right, i-1);
		}
	}*/

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
