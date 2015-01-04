package heap;

public class Heap implements PriQueueInterface {
	private Comparable[] elements; // Array that holds priority queue elements
	private int lastIndex; // Index of last element in priority queue
	private int maxIndex; // Index of last position in array

	// Constructor
	public Heap(int maxSize) {
		elements = new Comparable[maxSize];
		lastIndex = -1;
		maxIndex = maxSize - 1;
	}

	public boolean isEmpty()
	// Determines whether this priority queue is empty
	{
		return (lastIndex == -1);
	}

	public boolean isFull()
	// Determines whether this priority queue is full
	{
		return (lastIndex == maxIndex);
	}

	@Override
	public void enqueue(Comparable item) {
		// TODO Auto-generated method stub
		// Throws PriQOverflowException if priority queue already full

		if (lastIndex == maxIndex)
			throw new PriQOverflowException("Priority queue is full");
		else {
			lastIndex = lastIndex + 1;
			reheapUp(item);
		}
		for (int i = 0; i < lastIndex; i++) {
			//System.out.println("sun" + i + ":" + elements[i]);
		}
	}

	private void reheapUp(Comparable item)
	// Current lastIndex position is empty
	// Inserts item into the tree and maintains shape and order properties
	{
		int hole = lastIndex;
		while ((hole > 0) // Hole is not root
				&& // Short circuit
				(item.compareTo(elements[(hole - 1) / 2]) > 0)) // item > hole's
			// parent
		{
			elements[hole] = elements[(hole - 1) / 2]; // Move hole's parent
			// down
			hole = (hole - 1) / 2; // Move hole up
		}
		elements[hole] = item; // Place item into final hole
	}

	@Override
	public Comparable dequeue() {
		// TODO Auto-generated method stub
		// Removes element with highest priority from this priority queue
		// and returns a reference to it
		// Throws PriQUnderflowException if priority queue is empty

		Comparable hold; // Item to be dequeued and returned
		Comparable toMove; // Item to move down heap
		if (lastIndex == -1)
			throw new PriQUnderflowException("Priority queue is empty");
		else {
			hold = elements[0]; // Remember item to be returned
			toMove = elements[lastIndex]; // Item to reheap down
			lastIndex = lastIndex - 1; // Decrease priority queue size
			reheapDown(toMove); // Restore heap properties
			return hold;
		}
	}

	private void reheapDown(Comparable item)
	// Current root position is "empty";
	// Inserts item into the tree and ensures shape and order properties
	{
		int hole = 0; // Current index of hole
		int newhole; // Index where hole should move to
		newhole = newHole(hole, item); // Find next hole
		while (newhole != hole) {
			elements[hole] = elements[newhole]; // Move element up
			hole = newhole; // Move hole down
			newhole = newHole(hole, item); // Find next hole
		}
		elements[hole] = item; // Fill in the final hole
	}

	private int newHole(int hole, Comparable item)
	// If either child of hole is larger than item this returns the index
	// of the larger child; otherwise, it returns the index of hole
	{
		int left = (hole * 2) + 1;
		int right = (hole * 2) + 2;
		if (left > lastIndex)
			// Hole has no children
			return hole;
		else if (left == lastIndex)
			// Hole has left child only
			if (item.compareTo(elements[left]) < 0)
				// item < left child
				return left;
			else
				// item >= left child
				return hole;
		else
			// Ho le has two children
			if (elements[left].compareTo(elements[right]) < 0)
				// left child < right child
				if (elements[right].compareTo(item) <= 0)
					// right child <= item
					return hole;
				else
					// item < right child
					return right;
			else
				// left child >= right child
				if (elements[left].compareTo(item) <= 0)
					// left child <= item
					return hole;
				else
					// item < left child
					return left;
	}

	public static void main(String[] args) {
		Heap h = new Heap(10);
		h.enqueue(10);
		h.enqueue(8);
		h.enqueue(6);
		h.enqueue(2);

		h.enqueue(5);
		h.enqueue(1);
		h.enqueue(28);
		Comparable[] elements = h.elements;
		for (int i = 0; i < elements.length; i++) {
			System.out.println("i:" + elements[i]);
		}
		/* sorted array or heap sort */
		for (int i = 0; i < elements.length; i++) {
			System.out.println("i:" + h.dequeue());
		}
	}

}