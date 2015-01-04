package com.sec.java.stack;

public class ArrayStack implements StackInterface
{
private Object[] stack; // Array that holds stack elements
private int topIndex = -1; // Index of top element in stack
// Constructors
public ArrayStack()
{
	stack = new Object[100];
}
public ArrayStack(int maxSize)
{
	stack = new Object[maxSize];
}
public boolean isEmpty()
//Checks if the stack is empty
{
if (topIndex == -1)
return true;
else
return false;
}
public boolean isFull()
//Checks if the stack is full
{
if (topIndex == (stack.length - 1))
return true;
else
return false;
}
@Override
public void push(Object item) throws StackUnderflowException {
	// TODO Auto-generated method stub
	if (!isFull())
	{
		topIndex++;
		stack[topIndex] = item;
	}
	else
		throw new StackOverflowException("Push attempted on a full stack.");
	
}
@Override
public Object pop() throws StackUnderflowException {
	// TODO Auto-generated method stub
	if (!isEmpty())
	{
	Object res = stack[topIndex];
		stack[topIndex] = null;
	topIndex--;
	return res;
	}
	else
		throw new StackUnderflowException("Pop attempted on an empty stack.");
}
@Override
public Object top() throws StackUnderflowException {
	// TODO Auto-generated method stub
	Object topOfStack = null;
	if (!isEmpty())
		topOfStack = stack[topIndex];
		else
		throw new StackUnderflowException("Top attempted on an empty stack.");
		return topOfStack;
}



}