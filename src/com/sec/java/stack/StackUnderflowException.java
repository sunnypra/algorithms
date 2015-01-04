package com.sec.java.stack;

public class StackUnderflowException extends RuntimeException
{
public StackUnderflowException()
{
	}
public StackUnderflowException(String message)
{
	
super(message);
System.out.println("StackUnderflowException");
}
}