package tree;

import tree.BinarySearchTree.BSTNode;

import com.sec.java.queue.ArrayQueue;

public class CompletebinaryTree {
	public static void main(String [] args)
	{
	BinarySearchTree bt =  new BinarySearchTree();
	bt.insert(15);bt.insert(10);bt.insert(20);bt.insert(5);
	bt.insert(11);bt.insert(24);//bt.insert(6);
	/*BinarySearchTree.root.info=4;
	
	bt.insetBT(4);bt.insetBT(2);bt.insetBT(8);bt.insetBT(5);
	bt.insetBT(11);bt.insetBT(7);bt.insetBT(6);*/
	
	ArrayQueue aq= new ArrayQueue();
	aq.enqueue(bt.root);
	boolean t=false;
	while(!aq.isEmpty())
	{
		
		BSTNode b=(BSTNode) aq.dequeue();
		if(b.left !=null)
		{
			if(t)
			{
				//System.out.println("return left:"+b.left.info);
				return;
			}
			//t=true;
			aq.enqueue(b.left);
		}
		else // If this a non-full node, set the flag as true
		{
			//System.out.println("return left1:"+b.left.info);
		
		       t = true;
		}
		if(b.right!=null)
		{
			if(t)
			{
				System.out.println("return right");
				return ;
			}
			aq.enqueue(b.right);
		}
			else
			{
				//System.out.println("return left:"+b.right.info);
				t=true;
			}
		
		}
	System.out.println("full tree");
		
	}
	
}
