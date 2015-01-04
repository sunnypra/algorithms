package com.sec.java.stack;

public class StackOverflowException extends RuntimeException {
	public StackOverflowException()
	{}
	public StackOverflowException(String message)
	{
	super(message);
	}
}
