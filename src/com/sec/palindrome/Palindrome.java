package com.sec.palindrome;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.sec.java.queue.*;
import com.sec.java.stack.*;

import java.io.*;
import java.text.DecimalFormat;
/*import ch04.stacks.*;
import ch04.queues.*;*/
public class Palindrome
{
public static void main(String[] args) throws IOException
{
final int maxStringSize = 180; // Maximum size of an input line
int numStrings = 0; // Total number of strings processed
int palindromes = 0; // Number of palindromes found
int nonPalindromes = 0; // Number of nonpalindromes found
int tooLong = 0; // Number of strings too long to process
char ch; // Current input string character being
// processed
int numLetters; // Number of letter characters in current
// string
int charCount; // Number of characters checked so far
Character fromStack; // Current Char object popped from stack
Character fromQueue; // Current Char object dequeued from queue
boolean stillPalindrome; // True as long as the string might still
// be a palindrome
StackInterface stack; // Holds nonblank string characters
QueueInterface queue; // Also holds nonblank string characters
String line = null; // Input line
String dataFileName = "D:\\palindrome.txt";//args[0]; // Name of input file
String outFileName = "D:\\palindrome1.txt";//args[1]; // Name of output file
BufferedReader dataFile = new BufferedReader(new FileReader(dataFileName));
PrintWriter outFile = new PrintWriter(new FileWriter(outFileName));
DecimalFormat fmt = new DecimalFormat("000");
outFile.println(); // Print a blank line
line = dataFile.readLine(); // Read the first input line
System.out.println("line length:"+line.length());
while(line!=null) // while haven't read all of the input lines
{
	numStrings = numStrings + 1;
	outFile.println("String " + fmt.format(numStrings) + ": " + line);
	if (line.length() > maxStringSize)
	{
		tooLong = tooLong + 1;
		outFile.println("String too long - processing skipped");
	}
	else
	{
	// Check if line is a palindrome
			stack = new ArrayStack(maxStringSize);
			queue = new ArrayQueue(maxStringSize);
			numLetters = 0;
			for (int i = 0; i < line.length(); i++)
			{
				ch = line.charAt(i);
				if (Character.isLetter(ch))
					{
						numLetters = numLetters + 1;
						ch = Character.toLowerCase(ch);
						stack.push(new Character(ch));
						queue.enqueue(new Character(ch));
					}
			}
			stillPalindrome = true;
			charCount = 0;
			while (stillPalindrome && (charCount < numLetters))
			{
				fromStack = (Character)stack.top();
				stack.pop();
				fromQueue = (Character)queue.dequeue();
				if (!fromStack.equals(fromQueue))
				stillPalindrome = false;
				charCount++;
			}
			if (!stillPalindrome)
			{
				nonPalindromes = nonPalindromes + 1;
				outFile.println(" Not a palindrome ");
			}
			else
			{
				palindromes = palindromes + 1;
				outFile.println(" Is a palindrome.");
			}
		}
		outFile.println();
		line = dataFile.readLine(); // Set up processing of next line
	}
	dataFile.close();
	outFile.close();
	// Set up output frame
	JFrame outputFrame = new JFrame();
	outputFrame.setTitle("Palindromes");
	outputFrame.setSize(300,200);
	outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// Instantiate content pane and information panel
	Container contentPane = outputFrame.getContentPane();
	JPanel infoPanel = new JPanel();
	// Set layout
	infoPanel.setLayout(new GridLayout(6,1));
	infoPanel.add(new JLabel("Total Number Of Strings "+ numStrings));
	infoPanel.add(new JLabel("Number Of Strings too long for Processing " + tooLong));
	infoPanel.add(new JLabel("Number Of Palindromes "+ palindromes));
	infoPanel.add(new JLabel("Number Of Non Palindromes "+ nonPalindromes));
	infoPanel.add(new JLabel("Program completed. Close window to exit."));
	infoPanel.add(new JButton());
	contentPane.add(infoPanel);
	// Show information.
	outputFrame.show();
}
}