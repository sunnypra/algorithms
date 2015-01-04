package tree;


import tree.BinarySearchTree.BSTNode;

import com.sec.java.queue.ArrayQueue;

public class FullCompleteBinaryTree {
	public static void main(String [] args)
	{
	BinarySearchTree bt =  new BinarySearchTree();
	bt.insert(15);bt.insert(20);
	bt.insert(10);bt.insert(18);
	bt.insert(22);
	//bt.insert(20);bt.insert(5);
	//bt.insert(11);bt.insert(24);//bt.insert(6);
	/*BinarySearchTree.root.info=4;
	
	bt.insetBT(4);bt.insetBT(2);bt.insetBT(8);bt.insetBT(5);
	bt.insetBT(11);bt.insetBT(7);bt.insetBT(6);*/
	
	ArrayQueue aq= new ArrayQueue();
	aq.enqueue(bt.root);
	//boolean t=false;
	/*while(!aq.isEmpty())
	{
		
		BSTNode b=(BSTNode) aq.dequeue();
		if(b.left !=null && b.right!=null)
		{
			if(t)
			{
				System.out.println("inside b.left !=null && b.right!=null");
				return;
			}
			//t=true;
			aq.enqueue(b.left);
			aq.enqueue(b.right);
		}
		else if(b.left !=null || b.right!=null) // If this a non-full node, set the flag as true
		{
			System.out.println("inside b.left !=null || b.right!=null");
			return;
		}
		else if(b.left ==null && b.right==null)
		{
			t=true;
		
		}
		
	}*/
	int counter =0;
	while(!aq.isEmpty())
	{
		boolean cond=false;
		 for(int i=0; i<Math.pow(2,counter);i++)//checking all the root at tht level
		 {
			  BSTNode b=(BSTNode) aq.queue[i];
			 
			  if(b==null)
			  {
				  
				  return;
				  
			  }
			  
			  if(!cond && b.left !=null && b.right!=null )
                  cond=true;
			  else  if(b.left!=null && b.right==null || b.right!=null && b.left==null)
			  {
				  System.out.println("Found a non Full binary tree condition1");
				  return ;
			  }
			  else if( b.left== null && b.right ==null)
			  {
				  if(cond)
				  {
					  System.out.println("Found a non Full binary tree condition2");
				 
					  return ;
				  }
				  else
				  {
					  System.out.println("sunny");
				  
					  cond=true;// 1  node at tht level both empty then all others shld be empty
				  }
                 
                   
          }
		 }
		 boolean t=false;
		 for(int i=0; i<Math.pow(2,counter);i++)
          {
			 BSTNode b=(BSTNode) aq.dequeue();
              if(b.left!=null )
                  aq.enqueue(b.left);
              else
            	 t=true;
               if(b.right!=null )  
                  aq.enqueue(b.right);
               else
               {
            	   if(t)
            		   return;
               }
          }
       counter++;
	}
	System.out.println("Full binary tree");
	}
}
