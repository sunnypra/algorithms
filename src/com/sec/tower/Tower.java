package com.sec.tower;

	import java.io.*;
	public class Tower
	{
	private static PrintWriter outFile; // Output data file
	public static void main(String[] args) throws IOException
	{
		// Prepare outputfile
		String outFileName ;//= args[1];
		outFile = new PrintWriter("D:\\tower.txt");
		// Get number of circles on starting peg
		int circleCount;
		circleCount = 4;//Integer.valueOf(args[0]).intValue();
		System.out.println("OUTPUT WITH " + circleCount + " CIRCLES");
		System.out.println("From original: ");
		doTowers(circleCount, 1, 2, 3);
		outFile.close();
	}
	public static void doTowers(
		int circleCount, // Number of circles to move
		int beginPeg, // Peg containing circles to move
		int auxPeg, // Peg holding circles temporarily
		int endPeg ) // Peg receiving circles being moved
	{
		System.out.println("###############circles: " + circleCount + " Begin: " +
		beginPeg + " Auxil: " + auxPeg + " End: " + endPeg);
		if (circleCount > 0)
		{
		// Move n – 1 circles from beginning peg to auxiliary peg
		System.out.println("From first: ");
		doTowers(circleCount- 1, beginPeg, endPeg, auxPeg);
		System.out.println("Move circle from peg " + beginPeg
		+ " to peg " + endPeg);
		// Move n – 1 circles from auxiliary peg to ending peg
		System.out.println("From Second: ");
		doTowers(circleCount- 1, auxPeg, beginPeg, endPeg);
		}
		}
		
}
