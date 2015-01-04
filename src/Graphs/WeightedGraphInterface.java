package Graphs;
import com.sec.java.queue.*;
public interface WeightedGraphInterface
{
public boolean isEmpty();
// Effect: Determines whether this graph is empty
// Postcondition: Return value = (this graph is empty)
public boolean isFull();
// Effect: Determines whether this graph is full
// Postcondition: Return value = (this graph is full)
public void addVertex(Object vertex);
// Effect: Adds vertex to the graph
// Precondition: Graph is not full
// Postcondition: vertex is in V(graph)
public void addEdge(Object fromVertex, Object toVertex, int weight);
// Effect: Adds an edge with the specified weight from fromVertex
// to toVertex
// Precondition: fromVertex and toVertex are in V(graph)
// Postcondition: (fromVertex, toVertex) is in E(graph) with the specified
// weight

public int weightIs(Object fromVertex, Object toVertex);
//Effect: Determines the weight of the edge from fromVertex to
//toVertex
//Precondition: fromVertex and toVertex are in V(graph)
//Postcondition: if edge exists, Return value = (weight of edge from
//fromVertex to toVertex);
//otherwise, return value = (special "null-edge" value)
public QueueInterface getToVertices(Object vertex);
//Effect: Returns a queue of the vertices that are adjacent from
//vertex
//Precondition: vertex is in V(graph)
//Postcondition: returns a queue containing all the vertices that are
//adjacent from vertex
}