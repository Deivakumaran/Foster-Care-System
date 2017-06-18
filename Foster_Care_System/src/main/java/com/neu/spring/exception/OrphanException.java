package com.neu.spring.exception;

public class OrphanException extends Exception {
	public OrphanException(String message)
	{
		super("OrphanException-"+ message);
	}
	
	public OrphanException(String message, Throwable cause)
	{
		super("OrphanException-"+ message,cause);
	}
}
