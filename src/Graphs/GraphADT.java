package Graphs;

import java.util.Vector;

abstract class GraphADT
{
	// Need default constructor, copy and BufferedReader constructors
	// (commented since java doesn’t allow abstract constructors!)
	//
	// public GraphADT();
	// public GraphADT(GraphADT);
	// public GraphADT(BufferedReader in);
	// data structure modifiers
	//
	abstract public void addVertices(int i); // Add some vertices
	abstract public void removeVertex(int i); // Remove vertex
	abstract public void addArc(int i, int j); // Add directed edge
	public void addEdge(int i, int j) // Add undirected edge
	{ addArc(i,j); addArc(j,i); }
	abstract public void removeArc(int i, int j); // Remove directed edge
	public void removeEdge(int i, int j) // Remove undirected edge
	{ 
		removeArc(i,j); removeArc(j,i);
	}

abstract public boolean isArc(int i, int j); // Check for arcs
public boolean isEdge(int i, int j) // Check for edges
{ return isArc(i,j) && isArc(j,i); }
abstract public int inDegree(int i); // indegree
abstract public int outDegree(int i); // outdegree
public int degree(int i) // Number of neighbours
{ return outDegree(i); }
abstract public Vector neighbors(int i); // List of (out-) neighbours
abstract public int order(); // Number of vertices
abstract public int size();	
//output (default same as representation)
//
abstract public String toString();
// two common external text representations for graphs follow
//
public String toStringAdjMatrix()
{
	StringBuffer o = new StringBuffer();
	o.append(order()+"\n");
	for( int i = 0; i < order(); i++ )
	{
		for( int j = 0; j < order(); j++ )
		{
			if ( isArc(i,j) ) o.append("1 ");
			else o.append("0 ");
		}
		o.append("\n");
	}
	return o.toString();
}
public String toStringAdjLists()
{
	StringBuffer o = new StringBuffer();
	o.append(order()+"\n");
	for( int i = 0; i < order(); i++ )
	{
		for( int j = 0; j < order(); j++ )
		{
			if ( isArc(i,j) ) o.append(j+" ");
		}
		o.append("\n");
	}
	return o.toString();
}
} //