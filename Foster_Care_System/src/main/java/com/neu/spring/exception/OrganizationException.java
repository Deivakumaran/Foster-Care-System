package com.neu.spring.exception;

public class OrganizationException extends Exception
{
	public OrganizationException(String message)
	{
		super("AdvertException-"+ message);
	}
	
	public OrganizationException(String message, Throwable cause)
	{
		super("OrganizationException-"+ message,cause);
	}
}