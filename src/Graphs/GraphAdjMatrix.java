package Graphs;

import java.io.*;
import java.util.*;
/* Current implementation uses adjacency matrix form of a graph.
 */
public class GraphAdjMatrix extends GraphADT
{
	// ---------------------------------------------------------------
	// Internal Representation and Constructors
	// ---------------------------------------------------------------
	private int _space; // Current space allocated.
	private int _order; // Number of vertices.
	private boolean _adj[][]; // Adjacency matrix of graph.
	private static boolean _allocate(int n)[][] // Free store routines.
	                                          {
		return new boolean[n][n];
	                                          }
	public GraphAdjMatrix() // default constructor
	{
		_space = _order = 0;
	}
	public GraphAdjMatrix(GraphAdjMatrix G) // copy constructor
	{
		int n = G.order();
		if ( n>0 ) _adj = _allocate( n );
		_space = _order = n;
		for( int i = 0; i < n; i++ )
			for( int j = 0; j < n; j++ )
				_adj[i][j] = G._adj[i][j];
	}
	public GraphAdjMatrix(BufferedReader buffer)
	{
		try {
			String line=buffer.readLine();
			StringTokenizer token = new StringTokenizer(line);
			if ( token.countTokens() != 1 )
				throw new Error("bad format: number of vertices");
			int n = Integer.parseInt(token.nextToken());
			if ( n>0 ) _adj = _allocate( n );
			_order = _space = n;
			for( int i = 0; i < n; i++ )
			{
				line = buffer.readLine();
				token = new StringTokenizer(line);
				if ( token.countTokens() != n )
					throw new Error("bad format: adjacency matrix");
				for( int j = 0; j < n; j++ )
				{
					int entry = Integer.parseInt( token.nextToken() );
					_adj[i][j] = ( entry != 0 );
				}
			}
		} catch (IOException x) {
			throw new Error("bad input stream");
		}
	}

	// ---------------------------------------------------------------
	// Mutator Methods
	// ---------------------------------------------------------------
	public void addVertices(int n)
	{
		if ( n > _space - _order )
		{
			boolean matrix[][] = _allocate( _order + n );
			for( int i = 0; i < _order; i++ )
			{
				for( int j = 0; j < _order; j++ )
					matrix[i][j] = _adj[i][j];
			}
			_adj = matrix;
			_space = _order + n;
		}
		else // expand and reclean matrix
		{
			for( int i = 0; i < _order + n; i++ )
			{
				for( int j = _order; j < _order + n; j++ )
					_adj[i][j] = _adj[j][i] = false;
			}
		}
		_order += n;
	}
	public void removeVertex(int v)
	{
		_order--;
		int i;
		for( i = 0; i < v; i++ )
		{
			for( int j = v; j < _order; j++ )
			{
				_adj[i][j] = _adj[i][j + 1];
			}
		}
		for( i = v; i < _order; i++ )
		{
			int j;
			for( j = 0; j < v; j++ )
			{
				_adj[i][j] = _adj[i + 1][j];
			}
			for( j = v; j < _order; j++ )
			{
				_adj[i][j] = _adj[i + 1][j + 1];
			}
		}
	}


	public void addArc(int i, int j)
	{
		_adj[i][j] = true;
	}
	public void removeArc(int i, int j)
	{
		_adj[i][j] = false;
	}


	public boolean isArc(int i, int j)
	{
		return _adj[i][j];
	}
	public int inDegree(int i)
	{
		int sz = 0;
		for( int j = 0; j < _order; j++ ) if ( _adj[j][i] ) sz++;
		return sz;
	}
	public int outDegree(int i)
	{
		int sz = 0;
		for( int j = 0; j < _order; j++ ) if ( _adj[i][j] ) sz++;
		return sz;
	}

	public Vector neighbors(int i)
	{
		Vector nbrs = new Vector();
		for (int j= 0; j<_order; j++)
		{
			if ( _adj[i][j] ) nbrs.addElement( new Integer(j) );
		}
		return nbrs;
	}
	public int order() { return _order; }
	public int size() // Number of arcs (edges count twice)
	{
		int sz = 0;
		// boolean undirected = true;
		for( int i = 0; i < _order; i++ )
			for( int j = 0; j < _order; j++ )
			{
				if ( _adj[i][j] ) sz++;
				// if ( _adj[i][j] != _adj[j][i] ) undirected = false;
			}
		return sz; // undirected ? sz / 2 : sz;
	}
	// default output is readable by constructor
	//
	public String toString() { return toStringAdjMatrix(); }
} // end class GraphAdjMatrixs

