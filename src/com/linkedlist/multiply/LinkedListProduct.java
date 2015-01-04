package com.linkedlist.multiply;

import java.util.LinkedList;

public class LinkedListProduct {
	public  static void main(String [] args)
	{
		
	
	LinkedList<Integer> l1 = new LinkedList();
	LinkedList<Integer> l2 = new LinkedList();
	LinkedList<Integer> res = new LinkedList();
	l1.add(1);
	l1.add(2);
	l1.add(3);
	l2.add(2);
	l2.add(3);
	int count=0;
	for(int i=0;i<l2.size();i++) 
	{
		count=(int) (count*(Math.pow(10,i))+l2.get(i));
	}
	System.out.println("count:"+count);
	for (int i=0;i<1;i++)
	{
		if(i==0)
			res=l1;
		else
			
	}
	
	}
}
