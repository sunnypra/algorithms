package heap;

public interface PriQueueInterface
//Interface for a class that implements a priority queue of Comparable Objects
{
public boolean isEmpty();
//Effect: Determines whether this priority queue is empty
//Postcondition: Return value = (this priority queue is empty)
public boolean isFull();
//Effect: Determines whether this priority queue is full
//Postcondition: Return value = (priority queue is full)
public void enqueue(Comparable item);
//Effect: Adds item to this priority queue
//Postconditions: If (this priority queue is full)
//an unchecked exception that communicates 'enqueue
//on priority queue full' is thrown
//Else
//item is in this priority queue
public Comparable dequeue();
//Effect: Removes element with highest priority from this
//priority queue and returns a reference to it
//Postconditions: If (this priority queue is empty)
//an unchecked exception that communicates 'dequeue
//on empty priority queue' is thrown
//Else
//Highest priority element has been removed.
//Return value = (the removed element)
}