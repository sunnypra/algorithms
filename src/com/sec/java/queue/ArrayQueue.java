package com.sec.java.queue;

public class ArrayQueue implements QueueInterface
{
public Object[] queue; // Array that holds queue elements
private int capacity; // Size of the array (capacity of the queue)
public int numItems = 0; // Number of items on the queue
private int front = -1; // Index of front of queue
private int rear = 0; // Index of rear of queue
// Constructors
public ArrayQueue()
{
queue = new Object[100];
capacity = 100;
}
public ArrayQueue(int maxSize)
{
queue = new Object[maxSize];
capacity = maxSize;
}
@Override
public void enqueue(Object item) {
	// TODO Auto-generated method stub
	front = (front + 1) % capacity;
	queue[front] = item;
	numItems = numItems + 1;
}
@Override
public Object dequeue() {
	// TODO Auto-generated method stub
	Object toReturn = queue[rear];
	queue[rear] = null;
	rear = (rear + 1) % capacity;
	numItems = numItems - 1;
	//System.out.println("toReturn:"+toReturn);
	return toReturn;
}
@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return (numItems == 0);
}
@Override
public boolean isFull() {
	// TODO Auto-generated method stub
	return (numItems == capacity);
}
}
