package tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.sec.java.queue.ArrayQueue;
import com.sec.java.stack.LinkedStack;

public class BinarySearchTree implements BSTInterface
{
	protected ArrayQueue inOrderQueue; // Queue of info
	protected static ArrayQueue preOrderQueue; // Queue of info
	protected ArrayQueue postOrderQueue;
	protected class BSTNode
	{
		// Used to hold references to BST nodes for the linked implementation
		protected Comparable info; // The info in a BST node
		protected BSTNode left; // A link to the left child node
		protected BSTNode right; // A link to the right child node

	}
	protected static BSTNode root; // Reference to the root of this BST
	public BinarySearchTree()
	// Creates an empty BST object
	{
		root = null;
	}


	public boolean isFull()
	//Determines whether this BST is full
	{
		return false;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (root == null);
	}
	@Override
	public int numberOfNodes() {
		// TODO Auto-generated method stub
		int count = 0;
		if (root != null)
		{
			System.out.println("sunny_number nodes");
			LinkedStack hold = new LinkedStack();
			BSTNode currNode;
			hold.push(root);
			while (!hold.isEmpty())
			{
				currNode = (BSTNode) hold.top();
				if(currNode !=null)
				{
					hold.pop();
					count++;

					if (currNode.left != null)
						hold.push(currNode.left);
					if (currNode.right != null)
						hold.push(currNode.right);
				}
			}
		}
		return count;

	}
	public int numberOfNodes(BSTNode root1) {
		{
			if(root1== null)
				return 0;
			else
				return (numberOfNodes(root1.left)+1+numberOfNodes(root1.right));
		}
	}

	private boolean recIsThere(Comparable item, BSTNode tree)
	//Returns true if item is in tree; false otherwise
	{
		if (tree == null)
			return false; // Item is not found
		else if (item.compareTo(tree.info) < 0)
			return recIsThere(item, tree.left); // Search left subtree
		else if (item.compareTo(tree.info) > 0)
			return recIsThere(item, tree.right); // Search right subtree
		else
			return true; // Item is found
	}
	@Override
	public Comparable isThere(Comparable item) {
		// TODO Auto-generated method stub
		return recIsThere(item, root);
	}
	private Comparable recRetrieve(Comparable item, BSTNode tree)
	//Returns the element in tree with the same key as item
	{
		if (item.compareTo(tree.info) < 0)
			return recRetrieve(item, tree.left); // Retrieve from left subtree
		else
			if (item.compareTo(tree.info) > 0)
				return recRetrieve(item, tree.right); // Retrieve from right subtree
			else
				return tree.info;
	}
	@Override
	public Comparable retrieve(Comparable item) {
		// TODO Auto-generated method stub
		return recRetrieve(item, root);
	}
	@Override
	public void insert(Comparable item) {
		// TODO Auto-generated method stub
		root = recInsert(item, root);
	}
	private BSTNode recDelete(Comparable item, BSTNode tree)
	//Deletes item from the tree
	{
		if (item.compareTo(tree.info) < 0)
			tree.left = recDelete(item, tree.left);
		else if (item.compareTo(tree.info) > 0)
			tree.right = recDelete(item, tree.right);
		else
			tree = deleteNode(tree); // Item is found
		return tree;
	}

	private BSTNode deleteNode(BSTNode tree)
	//Deletes the node referenced by tree
	//Post: The user's data in the node referenced to by tree is no
	//longer in the tree. If tree is a leaf node or has only
	//a nonnull child pointer, the node pointed to by tree is
	//deleted; otherwise, the user's data is replaced by its
	//logical predecessor and the predecessor's node is deleted
	{
		Comparable data;
		if (tree.left == null)
			return tree.right;
		else if (tree.right == null)
			return tree.left;
		else
		{
			data = getPredecessor(tree.left);
			tree.info = data;
			tree.left = recDelete(data, tree.left); // Delete predecessor node.
			return tree;
		}
	}
	private Comparable getPredecessor(BSTNode tree)
	//Returns the info member of the rightmost node in tree
	{
		while (tree.right != null)
			tree = tree.right;
		return tree.info;
	}
	@Override
	public void delete(Comparable item) {
		// TODO Auto-generated method stub
		root = recDelete(item, root);
	}
	private BSTNode recInsert(Comparable item, BSTNode tree)
	//Inserts item into the tree
	{
		if (tree == null)
		{// Insertion place found
			tree = new BSTNode();
			tree.right = null;
			tree.left = null;
			tree.info = item;
		}
		else if (item.compareTo(tree.info) < 0)
			tree.left = recInsert(item, tree.left); // Insert in left
		//subtree
		else
			tree.right = recInsert(item, tree.right); // Insert in right
		//subtree
		return tree;
	}
	@Override
	public int reset(int orderType) {
		// TODO Auto-generated method stub
		System.out.print("sunny1:"+orderType);
		int numNodes = numberOfNodes(root);
		System.out.print("sunny_numNodes:"+numNodes);
		if (orderType == INORDER)
		{
			System.out.print("sunny_inoder");
			inOrderQueue = new ArrayQueue(numNodes);
			inOrder(root);
		}

		if (orderType == 2)
		{
			System.out.print("sunny_preoder");
			preOrderQueue = new ArrayQueue(numNodes);
			preOrder(root);
		}
		if (orderType == POSTORDER)
		{
			System.out.print("sunny_postorder");
			postOrderQueue = new ArrayQueue(numNodes);
			postOrder(root);
		}
		return numNodes;
	}
	@Override
	public Comparable getNextItem(int orderType) {
		// TODO Auto-generated method stub
		if (orderType == INORDER)
			return (Comparable)inOrderQueue.dequeue();
		else
			if (orderType == PREORDER)
				return (Comparable)preOrderQueue.dequeue();
			else
				if (orderType == POSTORDER)
					return (Comparable)postOrderQueue.dequeue();
				else return null;
	}

	private int recNumberOfNodes(BSTNode tree)
	//Determines the number of nodes in tree
	{
		if (tree == null)
			return 0;
		else
			return recNumberOfNodes(tree.left) +recNumberOfNodes(tree.right) + 1;
	}
	void inOrder(BSTNode tree)
	//Initializes inOrderQueue with tree elements in inOrder order
	{
		if (tree != null)
		{
			inOrder(tree.left);
			inOrderQueue.enqueue(tree.info);
			inOrder(tree.right);
		}
	}
	private void preOrder(BSTNode tree)
	//Initializes preOrderQueue with tree elements in preOrder order
	{
		if (tree != null)
		{
			preOrderQueue.enqueue(tree.info);
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
	private void postOrder(BSTNode tree)
	//Initializes postOrderQueue with tree elements in postOrder order
	{
		if (tree != null)
		{
			postOrder(tree.left);
			postOrder(tree.right);
			postOrderQueue.enqueue(tree.info);
		}
	}
	public void insetBT(Comparable data)
	{
		reccreateBT(data, root);
	}

	private void reccreateBT(Comparable item, BSTNode tree)
	{
		/*if (tree == null)
	{// Insertion place found
ArrayQueue res = new ArrayQueue();	
		 */	
		ArrayQueue res =null;
		BSTNode temp =null;
		BSTNode newnode =null;
		newnode = new BSTNode();
		newnode.right = null;
		newnode.left = null;
		newnode.info = item;
		if (root == null)
		{
			root=newnode;
		}
		else 
		{
			res = new ArrayQueue();
			res.enqueue(root);
			while(!res.isEmpty()){
				temp= (BSTNode) res.dequeue();
				if(temp.left!=null)
					res.enqueue(temp.left);
				else
				{
					temp.left=newnode;

					return;
				}
				if(temp.right!=null)
					res.enqueue(temp.right);
				else
				{
					temp.right=newnode;
					return;

				}
			}
		}

	}
	public void caldiameter()
	{
		int res =diameter(root,0);
		System.out.println("res:"+res);
	}
	private int diameter(BSTNode tree,int height)
	{
		int lht,rht;
		if(tree==null)
			return 0;
		System.out.println("height:"+height);
		lht=	diameter(tree.left,height);
		rht=	diameter(tree.right,height);
		if(lht+rht>height)
			height=lht+rht;
		return 1+(lht>rht?lht:rht);
	}
	Map<Integer, Integer> hash= null;
	public void calcVerticalSum(int start)
	{

		/*for (int i=-10;i<10;i++)
		hash.put(i, 0);*/
		hash= new HashMap();//<Integer, Integer> ();
		calvertical(root,start);
		for (int i=-10;i<10;i++)
			System.out.println(i+":"+"="+hash.get(i));
	}
	private void calvertical(BSTNode tree,int start){
		int val =0;
		if(tree==null)
			return;
		calvertical(tree.left,start-1);
		if(hash.containsKey(start))
			val= hash.get(start);
		else
			val=0;
		hash.put(start, val+(Integer) tree.info);
		//hash[start]+=(Integer) tree.info;
		calvertical(tree.right,start+1);
	}

	public void nodebetwweensum(int start,int end)
	{

		inordersum(root,start,end);
	}
	public static void inordersum(BSTNode tree,int start,int end)
	{
		if(tree==null || ((Integer) tree.info<start)|| ((Integer) tree.info>end) )
		{
			return;
		}
		inordersum(tree.left,start,end);
		System.out.println("val:"+tree.info);	
		inordersum(tree.right,start,end);
	}
	public static void main(String [] args)
	{


		BinarySearchTree bt =  new BinarySearchTree();
		/*	char  [] inorder= {'D','B','E','A','F','C'};
	char [] preordrer = {'A','B','D','E','C','F'};
	int pl = preordrer.length;
	int il = inorder.length;
	bt.createbt(inorder,preordrer,0,il);*/
		/*for (int i=0;i<5;i++)
	{
		root.info=5;

	}*/
		//Sum from right
		/*bt.insert(5);
	bt.insert(10);
	bt.insert(2);
	bt.sumfromright(root);
	System.out.println("count:"+aq.numItems);
	for (int i=0;i<aq.numItems;i++)
	{
		System.out.println("element 111:"+aq.queue[i]);
	}
	for (int i=0;i<aq.numItems;i++)
	{
		for(int j=i+1;j<aq.numItems;j++)
		{
			if(!aq.queue[i].equals('\0')&& !aq.queue[j].equals('\0'))
			{
				aq.queue[i]=(Integer)aq.queue[i] + (Integer)aq.queue[j];
			}
		}
		System.out.println("element :"+aq.queue[i]);
	}*/

		//Summ from right ends here
		bt.insert(4);bt.insert(2);bt.insert(8);bt.insert(5);
		bt.insert(11);bt.insert(7);bt.insert(6);//bt.insert(5);
		LCA();
		/*bt.insetBT(1);
	bt.insetBT(2);bt.insetBT(3);bt.insetBT(4);bt.insetBT(5);bt.insetBT(6);bt.insetBT(7);*/
		System.out.println("no.of element : "+bt.recNumberOfNodes(root));
		//bt.caldiameter();
		int res=bt.reset(2);
		/*while(!preOrderQueue.isEmpty())
	{
		System.out.println("element :"+preOrderQueue.dequeue());
	}
	bt.calcVerticalSum(0);*/

		//	bt.nodebetwweensum(2,20);
	}

	static int c=0;

	public static ArrayQueue aq = new ArrayQueue();
	public void sumfromright(BSTNode tree)
	{

		if(tree == null)
		{
			aq.enqueue('\0');
			return;
		}
		sumfromright(tree.right);
		aq.enqueue((Integer)tree.info);
		sumfromright(tree.left);



	}
	public  BSTNode createbt(char[] inorder , char[] preordrer, int pl, int il)
	{
		System.out.println("c :"+c);
		System.out.println("pl :"+pl);
		System.out.println("il :"+il);
		//static int c=0;
		if(pl>il)
			return null;


		root= new BSTNode();

		// BSTNode newnode = new BSTNode();
		if(c==6)
			root=null;
		else
		{
			root.info= preordrer[c];

			c++;
		}
		// root=newnode;
		if(pl==il)
			return root;
		System.out.println("(Character) root.info :"+(Character) root.info);
		//int pos =Arrays.binarySearch(inorder, (Character) root.info);
		int pos=-1;
		for(int i=0;i<il;i++)
		{
			if(inorder[i]==(Character) root.info)
				pos = i;
		}
		System.out.println("pos :"+pos);


		root.left=createbt(inorder,preordrer,pl,pos-1);
		root.right=createbt(inorder,preordrer,pos+1,il);
		return root;
	}
	public static void LCA()
	{
		LCAbwNode(root,6,11);
	}
	public static void LCAbwNode(BSTNode tree,int a,int b)
	{
		while(true)
		{
			if((a<=(Integer)tree.info && (Integer)tree.info<=b) || (a>=(Integer)tree.info && (Integer)tree.info>=b))
			{
				System.out.println("LCA:"+(Integer)tree.info);

				return;
			}
			if(a<(Integer)tree.info )
				tree=tree.left;
			else
				tree=tree.right;
		}
		//LCAbwNode(root,6,11);
	}
}