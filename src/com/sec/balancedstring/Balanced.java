package com.sec.balancedstring;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.sec.java.stack.ArrayStack;
import com.sec.java.stack.StackInterface;
import com.sec.java.stack.StackUnderflowException;

import java.io.*;
//import ch04.stacks.*;
import java.text.DecimalFormat;
public class Balanced
{
public static boolean openSet(char ch)
// Returns true if ch is one of (, [, {
{
return ( (ch == '(')
|| (ch == '[')
|| (ch == '{'));
}
public static boolean closeSet(char ch)
// Returns true if ch is one of ), ], }
{
return ( (ch == ')')
|| (ch == ']')
|| (ch == '}'));
}
public static void main(String[] args) throws IOException
{
	int numStrings = 0; // Total number of strings processed
	int wellFormed = 0; // Number of well-formed strings found
	int illFormed = 0; // Number of ill-formed strings found
	char currChar; // Current string character being studied
	int currCharIndex; // Index of current character
	int lastCharIndex; // Index of last character in the string
	char openSymbol; // Open symbol character popped from stack
	boolean balancedString; // True as long as string is balanced
	StackInterface stack; // Holds unmatched open symbols
	String line = null; // Input line
	String dataFileName = args[0]; // Name of input file
	String outFileName = args[1]; // Name of output file
	BufferedReader dataFile = new BufferedReader(new FileReader(dataFileName));
	PrintWriter outFile = new PrintWriter(new FileWriter(outFileName));
	DecimalFormat fmt = new DecimalFormat("00");
	line = dataFile.readLine(); // Read the first input line.
	while(line!=null) // While haven't read all of the input
	// lines
	{
		numStrings++;
		outFile.println("String " + fmt.format(numStrings) + ": " + line);
		outFile.print(" ");
		balancedString = true;
		stack = new ArrayStack();
		currCharIndex = 0;
		lastCharIndex = line.length() - 1;
	while (balancedString && (currCharIndex <= lastCharIndex))
	{
		currChar = line.charAt(currCharIndex);
		outFile.print(currChar);
		if(openSet(currChar)) // If the current character is one of [, {, (
		{
		// Wrap the character and push it onto the stack
		Character openSymbolObject = new Character(currChar);
		stack.push(openSymbolObject);
		}
		else
		{
		if(closeSet(currChar)) // If the current character is one of ], }, )
		{
			try // Try to pop a character off the stack
			{
				openSymbol = ((Character)stack.top()).charValue();
				stack.pop();
				// If the popped character doesn't match
				if ( !( ((currChar == ')') && (openSymbol == '('))
				||((currChar == ']') && (openSymbol == '['))
				||((currChar == '}') && (openSymbol == '{'))))
				balancedString = false;
			}
			catch(StackUnderflowException e) // Stack was empty
			{
				balancedString = false;
				}
				}
			}
			currCharIndex++; // Set up processing of next character
		}
		if (!balancedString)
		{
			illFormed++;
			outFile.println(" Unbalanced symbols ");
		}
		else
			if (!stack.isEmpty())
			{
				illFormed++;
				outFile.println(" Premature end of string");
			}
			else
			{
				wellFormed++;
				outFile.println(" The string is balanced.");
			}
			outFile.println();
			line = dataFile.readLine(); // Set up processing of next line
		}
	dataFile.close();
	outFile.close();
	//Set up output frame
	JFrame outputFrame = new JFrame();
	outputFrame.setTitle("Balanced Parenthesis");
	outputFrame.setSize(300,200);
	outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container contentPane = outputFrame.getContentPane();
	JPanel infoPanel = new JPanel();
	// Set layout.
	infoPanel.setLayout(new GridLayout(4,1));
	infoPanel.add(new JLabel("Total Number Of Strings "+ numStrings));
	infoPanel.add(new JLabel("Total Number Of Well Formed Strings "+
	wellFormed));
	infoPanel.add(new JLabel("Total Number Of Ill Formed Strings "+
	illFormed));
	infoPanel.add(new JLabel("Program completed. Close window to exit"));
	contentPane.add(infoPanel);
	// Show information.
	outputFrame.show();
}
}