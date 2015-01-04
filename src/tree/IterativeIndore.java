package tree;

import com.sec.java.stack.ArrayStack;

import tree.BinarySearchTree.BSTNode;

public class IterativeIndore {
	public static void main(String [] args)
	{
	BinarySearchTree bt =  new BinarySearchTree();
	bt.insert(4);bt.insert(2);bt.insert(8);bt.insert(5);
	bt.insert(11);bt.insert(7);bt.insert(6);//bt.insert(5);
	ArrayStack st= new ArrayStack();
	BSTNode rt = bt.root;

	/*Inorder
	while(true)
{
	while(rt!=null)
	{
	st.push(rt);
rt=rt.left;
		
	}
	if(st.isEmpty())
		break;
	rt=(BSTNode) st.pop();
	System.out.println("element:"+(Integer)rt.info);
	rt=rt.right;
	}*/
	
	
	///preoder
	/*while(true)
	{
	while(rt!=null)
		{
		System.out.println("element:"+(Integer)rt.info);
		st.push(rt);
		//if(rt.left!=null)
		rt=rt.left;
		}		
		
		if(st.isEmpty())
			break;
		rt=(BSTNode) st.pop();
	
			rt=rt.right;
		}*/
	//postorder
	while(true)
	{
		if(rt!=null)
		{
			st.push(rt);
			rt=rt.left;	
		}
		else
			{
			if(st.isEmpty()){
			
			break;
			}
		else
			if (((BSTNode)st.top()).right==null)
			{
				rt=(BSTNode) st.pop();
				System.out.println("element:"+(Integer)rt.info);
				if(rt==((BSTNode)st.top()).right)
				{
					System.out.println("element:"+(Integer)(((BSTNode)st.top()).right).info);
				}
			}
	}
}
}